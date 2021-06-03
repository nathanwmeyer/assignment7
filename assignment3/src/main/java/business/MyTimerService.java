package business;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class MyTimerService {

	private static final Logger logger = Logger.getLogger("business.TimerService");
	
	@Resource
	TimerService timerService;
	
    /**
     * Default constructor. 
     */
    public MyTimerService() {
        // TODO Auto-generated constructor stub
    }
    
    public void setTimer(long interval) {
    	timerService.createTimer(interval, "My Timer");
    }
    
    @Timeout
    public void programmicTimer(Timer timer) {
    	logger.info("@Timeout has occured at: " + new java.util.Date());
    }
	
	@SuppressWarnings("unused")
	@Schedule(second="*/10", minute="*", hour="0-23", dayOfWeek="Mon-Fri",
      dayOfMonth="*", month="*", year="*", info="MyTimer")
    private void scheduledTimeout(final Timer t) {
        logger.info("@Schedule called at: " + new java.util.Date());
    }
}