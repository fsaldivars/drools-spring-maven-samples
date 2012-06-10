package org.drools.examples;

import org.drools.tutorials.banking.RuleRunner;
import org.drools.tutorials.banking.SimpleDate;
import org.drools.tutorials.banking.TypedCashflow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:bank-creditdebit-rule-config.xml" })
public class CreditDebitRuleTest {

	@Autowired
	RuleRunner ruleRunner;

	@Test
	public void testMain() throws Exception {
        Object[] cashflows = {
                new TypedCashflow(new SimpleDate("01/01/2007"),    
                                  TypedCashflow.CREDIT, 300.00),
                new TypedCashflow(new SimpleDate("05/01/2007"),
                                  TypedCashflow.CREDIT, 100.00),
                new TypedCashflow(new SimpleDate("11/01/2007"),
                                  TypedCashflow.CREDIT, 500.00),
                new TypedCashflow(new SimpleDate("07/01/2007"),
                                  TypedCashflow.DEBIT, 800.00),
                new TypedCashflow(new SimpleDate("02/01/2007"),
                                  TypedCashflow.DEBIT, 400.00),
            };
            
            ruleRunner.runRules( cashflows );
	}
}
