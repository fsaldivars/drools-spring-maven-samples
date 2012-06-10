package org.drools.tutorials.banking;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;

public class RuleRunner {

	private StatefulKnowledgeSession ksession;

	private KnowledgeBase kbase;

	private String  ruleFile;

	public KnowledgeBase getKbase() {
		return kbase;
	}

	public void setKbase(KnowledgeBase kbase) {
		this.kbase = kbase;
	}

	public StatefulKnowledgeSession getKsession() {
		return ksession;
	}

	public void setKsession(StatefulKnowledgeSession ksession) {
		this.ksession = ksession;
	}

	public RuleRunner() {
    }

    public void runRules(Object[] facts) throws Exception {

		System.out.println("Loading file: " + ruleFile);

        for ( int i = 0; i < facts.length; i++ ) {
            Object fact = facts[i];
            System.out.println( "Inserting fact: " + fact );
            ksession.insert( fact );
        }

        ksession.fireAllRules();
    }

	public String getRuleFile() {
		return ruleFile;
	}

	public void setRuleFile(String ruleFile) {
		this.ruleFile = ruleFile;
	}
}
