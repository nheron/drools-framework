package org.chtijbug.drools.guvnor.rest;

import org.chtijbug.drools.guvnor.GuvnorConnexionConfiguration;
import org.chtijbug.drools.guvnor.rest.dt.DecisionTable;
import org.drools.ide.common.client.modeldriven.dt52.GuidedDecisionTable52;
import org.drools.ide.common.server.util.GuidedDTXMLPersistence;

/**
 * Created by IntelliJ IDEA.
 * Date: 25/03/13
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
class DecisionTableManager {
    private GuvnorConnexionConfiguration configuration=null;

    private AssetManager assetManager=null;

     public DecisionTableManager(GuvnorConnexionConfiguration configuration,AssetManager assetManager) {
         this.configuration = configuration;
         this.assetManager = assetManager;
     }

    public DecisionTable getGuidedDecisionTable(String dtName) throws ChtijbugDroolsRestException {
        String content = this.assetManager.getAssetCodeInXML(dtName) ;
        GuidedDecisionTable52 guidedDecisionTable52 = GuidedDTXMLPersistence.getInstance().unmarshal(content);
        return new DecisionTable(guidedDecisionTable52);
    }

    public void commitChanges(DecisionTable guidedDecisionTable52)  throws ChtijbugDroolsRestException {
        String dtName = guidedDecisionTable52.getGuidedDecisionTable52().getTableName();
        String newContent = GuidedDTXMLPersistence.getInstance().marshal(guidedDecisionTable52.getGuidedDecisionTable52());
        this.assetManager.updateAssetCodeFromXML(dtName,newContent);
    }

}
