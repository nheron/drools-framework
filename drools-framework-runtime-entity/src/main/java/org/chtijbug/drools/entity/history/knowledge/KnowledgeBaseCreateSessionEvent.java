package org.chtijbug.drools.entity.history.knowledge;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Date: 05/06/13
 * Time: 12:08
 * To change this template use File | Settings | File Templates.
 */
public class KnowledgeBaseCreateSessionEvent extends KnowledgeBaseEvent {
    public KnowledgeBaseCreateSessionEvent(int eventID, Date dateEvent,  int ruleBaseID) {
        super(eventID, dateEvent, ruleBaseID);
    }
}