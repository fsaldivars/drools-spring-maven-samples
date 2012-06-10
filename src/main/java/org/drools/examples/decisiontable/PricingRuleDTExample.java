package org.drools.examples.decisiontable;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.drools.KnowledgeBase;
import org.drools.runtime.StatelessKnowledgeSession;

/**
 * This shows off a decision table.
 */
public class PricingRuleDTExample {

	private static Log logger = LogFactory.getLog(PricingRuleDTExample.class);
	
	private StatelessKnowledgeSession ksession;

	private KnowledgeBase kbase;

	public KnowledgeBase getKbase() {
		return kbase;
	}

	public void setKbase(KnowledgeBase kbase) {
		this.kbase = kbase;
	}

	public StatelessKnowledgeSession getKsession() {
		return ksession;
	}

	public void setKsession(StatelessKnowledgeSession ksession) {
		this.ksession = ksession;
	}

	public int executeExample(Driver driver, Policy policy) throws Exception {

		// now create some test data
		ksession.execute(Arrays.asList(new Object[] { driver, policy }));

		logger.debug("BASE PRICE IS: " + policy.getBasePrice());
		logger.debug("DISCOUNT IS: " + policy.getDiscountPercent());

		return policy.getBasePrice();
	}

}
