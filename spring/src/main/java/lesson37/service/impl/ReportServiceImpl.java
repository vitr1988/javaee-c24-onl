package lesson37.service.impl;

import lesson37.dao.ReportDao;
import lesson37.model.Report;
import lesson37.service.ReportService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportServiceImpl implements ReportService {

    private final ReportDao reportDao;
    private final String hello;

    public ReportServiceImpl(@Qualifier("defaultReportDao") ReportDao reportDao, String hello) {
        this.reportDao = reportDao;
        this.hello = hello;
    }

    @Override
    public void generateAndSave() {
        Report report = new Report(1L, "Annual report");
        reportDao.save(report);
    }

    @Override
    public void generateSomeAndSave() {
        List<Report> reports = List.of(
                new Report(1L, "Annual report"),
                new Report(2L, "Monthly report"),
                new Report(3L, "Daily report"),
                new Report(4L, hello)
        );
        reports.forEach(reportDao::save);
    }
}
