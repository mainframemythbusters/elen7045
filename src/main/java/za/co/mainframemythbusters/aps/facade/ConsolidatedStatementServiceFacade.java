/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mainframemythbusters.aps.facade;

import za.co.mythbusters.aps.model.internal.ConsolidatedStatement;
import za.co.mythbusters.aps.model.internal.Profile;


/**
 * Anti corruption layer. protects domain services and repositories from layers.
 */
public interface ConsolidatedStatementServiceFacade {
    public ConsolidatedStatement consolidateStatements(Profile profile);
}
