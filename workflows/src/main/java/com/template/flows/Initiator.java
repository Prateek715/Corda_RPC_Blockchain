package com.template.flows;

import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.utilities.ProgressTracker;

// ******************
// * Initiator flow *
// ******************
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.flows.*;
import net.corda.core.identity.Party;
import net.corda.core.utilities.ProgressTracker;

// ******************
// * Initiator flow *
// ******************
@InitiatingFlow
@StartableByRPC
public class Initiator extends FlowLogic<Integer> {

    private Party counterparty;
    private Integer number;

    private final ProgressTracker progressTracker = new ProgressTracker();

    public Initiator(Party counterparty , Integer number){
        this.number=number;
        this.counterparty=counterparty;
    }

    @Override
    public ProgressTracker getProgressTracker() {
        return progressTracker;
    }

    @Suspendable
    @Override
    public Integer call() throws FlowException {
        // Initiator flow logic goes here.

        FlowSession session=initiateFlow(counterparty);

        session.send(number);

        int rece=session.receive(Integer.class).unwrap(it->it);

        return rece;



    }
}

