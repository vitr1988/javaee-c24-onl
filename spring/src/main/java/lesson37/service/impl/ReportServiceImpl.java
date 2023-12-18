package lesson37.service.impl;

import lesson37.dao.ReportDao;
import lesson37.model.Report;
import lesson37.service.ReportService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Log4j
@Component
public class ReportServiceImpl implements ReportService {

    private final ReportDao reportDao;
    private final String hello;
    private final ReportService self;

    @Autowired
    public ReportServiceImpl(@Qualifier("defaultReportDao") ReportDao reportDao, @Value("${hello}") String hello, @Lazy ReportService reportService) {
        this.reportDao = reportDao;
        this.hello = hello;
        this.self = reportService;
//        Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{ReportService.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                //todo: предусловие
//                Object invoke = method.invoke(this, args);
//                //todo: постусловие
//                return invoke;
//            }
//        });
    }

    @PostConstruct
    public void init() {
        log.info("Component was initialized and successfully started");
    }

    @PreDestroy
    public void destroy() {
        log.info("Component was destroyed");
    }

    public ReportServiceImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
        this.hello = "hello";
        this.self = new ReportServiceImpl(reportDao, hello, null);
    }

//    public ReportServiceImpl(@Qualifier("defaultReportDao") ReportDao reportDao, String hello) {
//        this.reportDao = reportDao;
//        this.hello = hello;
//    }

    @Override
    public void generateAndSave() {
        Report report = new Report(1L, "Annual report");
        reportDao.save(report);
    }

    @Override
    public void generateSomeAndSave() {
//        log.info("ReportServiceImpl#generateSomeAndSave began");
        List<Report> reports = List.of(
                new Report(1L, "Annual report"),
                new Report(2L, "Monthly report"),
                new Report(3L, "Daily report"),
                new Report(4L, hello)
        );
        reports.forEach(reportDao::save);
        log.info(reportDao);
//        log.info("ReportServiceImpl#generateSomeAndSave end");
    }
}
