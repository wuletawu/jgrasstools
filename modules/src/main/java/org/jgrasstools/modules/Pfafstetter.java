/*
 * This file is part of JGrasstools (http://www.jgrasstools.org)
 * (C) HydroloGIS - www.hydrologis.com 
 * 
 * JGrasstools is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jgrasstools.modules;

import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_AUTHORCONTACTS;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_AUTHORNAMES;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_KEYWORDS;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_LABEL;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_LICENSE;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_NAME;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_STATUS;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_inChannel_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_inChannelfeatures_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_inFlow_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_inHackstream_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_inNetnum_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_inPit_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_outPfaf_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSPFAFSTETTER_pMode_DESCRIPTION;
import oms3.annotations.Author;
import oms3.annotations.Description;
import oms3.annotations.Execute;
import oms3.annotations.In;
import oms3.annotations.Keywords;
import oms3.annotations.Label;
import oms3.annotations.License;
import oms3.annotations.Name;
import oms3.annotations.Status;
import oms3.annotations.UI;

import org.jgrasstools.gears.libs.modules.JGTConstants;
import org.jgrasstools.gears.libs.modules.JGTModel;
import org.jgrasstools.hortonmachine.modules.network.pfafstetter.OmsPfafstetter;

@Description(OMSPFAFSTETTER_DESCRIPTION)
@Author(name = OMSPFAFSTETTER_AUTHORNAMES, contact = OMSPFAFSTETTER_AUTHORCONTACTS)
@Keywords(OMSPFAFSTETTER_KEYWORDS)
@Label(OMSPFAFSTETTER_LABEL)
@Name("_" + OMSPFAFSTETTER_NAME)
@Status(OMSPFAFSTETTER_STATUS)
@License(OMSPFAFSTETTER_LICENSE)
public class Pfafstetter extends JGTModel {

    @Description(OMSPFAFSTETTER_inPit_DESCRIPTION)
    @UI(JGTConstants.FILEIN_UI_HINT)
    @In
    public String inPit = null;

    @Description(OMSPFAFSTETTER_inFlow_DESCRIPTION)
    @UI(JGTConstants.FILEIN_UI_HINT)
    @In
    public String inFlow = null;

    @Description(OMSPFAFSTETTER_inHackstream_DESCRIPTION)
    @UI(JGTConstants.FILEIN_UI_HINT)
    @In
    public String inHackstream = null;

    @Description(OMSPFAFSTETTER_inNetnum_DESCRIPTION)
    @UI(JGTConstants.FILEIN_UI_HINT)
    @In
    public String inNetnum = null;

    @Description(OMSPFAFSTETTER_inChannel_DESCRIPTION)
    @UI(JGTConstants.FILEIN_UI_HINT)
    @In
    public String inChannel = null;

    @Description(OMSPFAFSTETTER_inChannelfeatures_DESCRIPTION)
    @UI(JGTConstants.FILEIN_UI_HINT)
    @In
    public String inChannelfeatures = null;

    @Description(OMSPFAFSTETTER_pMode_DESCRIPTION)
    @In
    public double pMode = 0;

    @Description(OMSPFAFSTETTER_outPfaf_DESCRIPTION)
    @UI(JGTConstants.FILEOUT_UI_HINT)
    @In
    public String outPfaf = null;

    @Execute
    public void process() throws Exception {
        OmsPfafstetter pfafstetter = new OmsPfafstetter();
        pfafstetter.inPit = getRaster(inPit);
        pfafstetter.inFlow = getRaster(inFlow);
        pfafstetter.inHackstream = getRaster(inHackstream);
        pfafstetter.inNetnum = getRaster(inNetnum);
        pfafstetter.inChannel = getRaster(inChannel);
        pfafstetter.inChannelfeatures = getVector(inChannelfeatures);
        pfafstetter.pMode = pMode;
        pfafstetter.pm = pm;
        pfafstetter.doProcess = doProcess;
        pfafstetter.doReset = doReset;
        pfafstetter.process();
        dumpVector(pfafstetter.outPfaf, outPfaf);
    }
}
