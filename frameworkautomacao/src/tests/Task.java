package tests;

import org.junit.Test;

import core.BaseTest;
import pages.BaseTask;

public class Task extends BaseTest {
	BaseTask bt = new BaseTask ();
	
	
	@Test
	public void criartask () {
		bt.clicarbotaonewtask();
		bt.preenchertask();
		
	}
}
