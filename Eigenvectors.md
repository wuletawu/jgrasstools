# Introduction #

In several scientific papers eigenvectors are used to calculate the flatness of a set of elevation coordinates.

In one paper for example, while trying to extract buildings from laserscan (LIDAR) data ("Using the Delaunay Triangulation/Voronoi Diagram to extract Building Information from raw LIDAR Data" by Rebecca Tse et al), it was stated that one could use the eigenvectors of a set of points inside a voronoi polygon, to separate the higher point (roof of building) from the lower ones (terrain near building) finding in the eigenvector with the lowest eigenvalue the "line of separation".

The following implementation tests want to first recreate this behaviour on simple datasets with few points.

# Eigenvalues intro #

The 2d example following is taken from [Lindsay Smith's great tutorial on Principle Components Analysis](http://www.cs.otago.ac.nz/cosc453/student_tutorials/principal_components.pdf).
The eigenvalue calculations are done throught the [apache math commons](http://commons.apache.org/proper/commons-math/) library.

# Example 1: points in 2d #

Assume the dataset (from the tutorial):

```
        double[] x = {2.5, 0.5, 2.2, 1.9, 3.1, 2.3, 2, 1, 1.5, 1.1};
        double[] y = {2.4, 0.7, 2.9, 2.2, 3.0, 2.7, 1.6, 1.1, 1.6, 0.9};
```

we calculate mean, covariance and eigenvectors:

```
        double meanX = mean(x);
        double meanY = mean(y);

        double[][] cov = covariance(x, y);

        // calculate the eigenvectors
        RealMatrix matrix = MatrixUtils.createRealMatrix(cov);
        EigenDecomposition eigenDecomposition = new EigenDecomposition(matrix);

        double eigenValue1 = eigenDecomposition.getRealEigenvalue(0);
        RealVector eigenVector1 = eigenDecomposition.getEigenvector(0);
        double[] eigenVectorData1 = eigenVector1.toArray();
        double eigenValue2 = eigenDecomposition.getRealEigenvalue(1);
        RealVector eigenVector2 = eigenDecomposition.getEigenvector(1);
        double[] eigenVectorData2 = eigenVector2.toArray();

        // sort eigenvectors by highest eigenvalue
        double[] firstEigenVector = eigenValue1 > eigenValue2 ? eigenVectorData1 : eigenVectorData2;
        double[] lastEigenVector = eigenValue1 > eigenValue2 ? eigenVectorData2 : eigenVectorData1;
```


where mean is:

```
    public static double mean( double[] values ) {
        double mean = 0;
        for( double value : values ) {
            mean += value;
        }
        return mean / values.length;
    }
```

and covariance:
```
    public static double[][] covariance( double[]... values ) {
        int length = values.length;
        double[] means = new double[length];
        for( int i = 0; i < length; i++ ) {
            means[i] = mean(values[i]);
        }

        double[][] covarianceMatrix = new double[length][length];

        for( int rows = 0; rows < length; rows++ ) {
            double[] vr = values[rows];
            double mr = means[rows];
            for( int cols = 0; cols < length; cols++ ) {
                double[] vc = values[cols];
                double mc = means[cols];
                double c = 0;
                for( int i = 0; i < vc.length; i++ ) {
                    c += (vr[i] - mr) * (vc[i] - mc);
                }
                c = c / (vc.length - 1);
                covarianceMatrix[rows][cols] = c;
            }
        }
        return covarianceMatrix;
    }
```


Since the eigenvectors represent vectors starting in the origin, we need to adjust the original data by the mean values to be able to plot them with the original data.

```
        // adjust to move to origin
        float[] adjX = new float[x.length];
        float[] adjY = new float[x.length];
        for( int i = 0; i < x.length; i++ ) {
            adjX[i] = (float) (x[i] - meanX);
            adjY[i] = (float) (y[i] - meanY);
        }
```

If we then plot the result, we get:

<a href='http://www.zimagez.com/zimage/eigenvectors2d.php' title=''><img src='http://www.zimagez.com/miniature/eigenvectors2d.png' alt='' /></a>

Where the blue line is the eigenvector with highest eigenvalue and the red line the one with lowest eigenvalue.

The eigenvector lines characterise the data:

  * the blue line (highest eigenvalue) goes through the middle of the points, like drawing a line of best fit
  * the red line instead tells us that all the points follow the main line, but are off to the side of the main line by some amount

# Example 2: points in 3d #

Let's try a test in 3d and see if we are able to separate higher elevation points from lower elevation points.
To do so we start with a simple dataset:

```
    /*
     *     | 1.0 | 2.0 | 3.0 
     * ----------------------
     * 2.0 | 2.0 | 2.0 | 2.0
     * 1.5 | 2.0 | 2.0 | 2.0
     * 1.0 | 1.0 | 1.0 | 1.0
     * 0.5 | 1.0 | 1.0 | 1.0
     */
        double[] x = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        double[] y = {0.5, 1, 1.5, 2, 0.5, 1, 1.5, 2, 0.5, 1, 1.5, 2};
        double[] z = {1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2};

```

Which results, following the schema of teh example 1 in calculation of eigenvectors and adjusting the original coordinates, in:

<a href='http://www.zimagez.com/zimage/eigenvectors3dcase1.php' title=''><img src='http://www.zimagez.com/miniature/eigenvectors3dcase1.png' alt='' /></a>

with the blue, green and red in order of higher eigenvalue first.

If we try to create a plane between the first and last eigenvector (based on the eigenvalue), we seem to gain a plane that clearly separates the higher values from the lower ones.

<a href='http://www.zimagez.com/zimage/eigenvectors3dcase1quad.php' title=''><img src='http://www.zimagez.com/miniature/eigenvectors3dcase1quad.png' alt='' /></a>


# Example 3: points in 3d #

Let's try the same with a slightly changed dataset. Two points are move in order to gain a more diagonal feeling:

```
    /**
     *     | 1.0 | 2.0 | 3.0 
     * ----------------------
     * 2.0 | 2.0 | 2.0 | 2.0
     * 1.5 | 1.0 | 2.0 | 2.0
     * 1.0 | 1.0 | 1.0 | 2.0
     * 0.5 | 1.0 | 1.0 | 1.0
     */
    double[] x = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
    double[] y = {0.5, 1, 1.5, 2, 0.5, 1, 1.5, 2, 0.5, 1, 1.5, 2};
    double[] z = {1, 1, 1, 2, 1, 1, 2, 2, 1, 2, 2, 2};
```

The eigenvectors result in:

<a href='http://www.zimagez.com/zimage/eigenvectors3dcase2.php' title=''><img src='http://www.zimagez.com/miniature/eigenvectors3dcase2.png' alt='' /></a>

an if we try to create the same plane between first and last eigenvector (sorted by eigenvalue), we do not get
what we wished for:

<a href='http://www.zimagez.com/zimage/eigenvectors3dcase2quad.php' title=''><img src='http://www.zimagez.com/miniature/eigenvectors3dcase2quad.png' alt='' /></a>

In this case the plane does not separate the higher values from the lower ones.

...this is a work in progress, to be continued...