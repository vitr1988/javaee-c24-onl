package lesson37.dao.impl;

import lesson37.dao.ReportDao;
import lesson37.model.Report;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Log4j
@Component("defaultReportDao")
@Scope("prototype")
public class ReportJdbcDao implements ReportDao {

    @Override
    public void save(Report report) {
        log.info("Try to save report " + report);
    }
}
