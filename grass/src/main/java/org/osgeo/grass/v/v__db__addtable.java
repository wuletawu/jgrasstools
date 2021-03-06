package org.osgeo.grass.v;

import org.jgrasstools.grass.utils.ModuleSupporter;

import oms3.annotations.Author;
import oms3.annotations.Documentation;
import oms3.annotations.Label;
import oms3.annotations.Description;
import oms3.annotations.Execute;
import oms3.annotations.In;
import oms3.annotations.UI;
import oms3.annotations.Keywords;
import oms3.annotations.License;
import oms3.annotations.Name;
import oms3.annotations.Out;
import oms3.annotations.Status;

@Description("Creates and connects a new attribute table to a given layer of an existing vector map.")
@Author(name = "Grass Developers Community", contact = "http://grass.osgeo.org")
@Keywords("vector, database, attribute table")
@Label("Grass/Vector Modules")
@Name("v__db__addtable")
@Status(Status.CERTIFIED)
@License("General Public License Version >=2)")
public class v__db__addtable {

	@UI("infile,grassfile")
	@Description("Vector map for which to add new attribute table")
	@In
	public String $$mapPARAMETER;

	@Description("Name of new attribute table (default: vector map name) (optional)")
	@In
	public String $$tablePARAMETER;

	@Description("Layer where to add new attribute table (optional)")
	@In
	public String $$layerPARAMETER = "1";

	@Description("Name and type of the new column(s) (types depend on database backend, but all support VARCHAR(), INT, DOUBLE PRECISION and DATE) (optional)")
	@In
	public String $$columnsPARAMETER = "cat integer";

	@Description("Verbose module output")
	@In
	public boolean $$verboseFLAG = false;

	@Description("Quiet module output")
	@In
	public boolean $$quietFLAG = false;


	@Execute
	public void process() throws Exception {
		ModuleSupporter.processModule(this);
	}

}
