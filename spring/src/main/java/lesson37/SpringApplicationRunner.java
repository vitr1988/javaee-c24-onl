package lesson37;

import lesson37.config.AppConfig;
import lesson37.dao.ReportDao;
import lesson37.service.ReportService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j
public class SpringApplicationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.scan("lesson37");
//        context.refresh();

        ReportDao reportDao = context.getBean(ReportDao.class);
        ReportDao reportDao2 = context.getBean("defaultReportDao", ReportDao.class);
        ReportService reportService = context.getBean(ReportService.class);

        log.info("dao - " + reportDao);
        log.info("dao2 - " + reportDao2);
        log.info("service - " + reportService);

        reportService.generateSomeAndSave();
    }
}
