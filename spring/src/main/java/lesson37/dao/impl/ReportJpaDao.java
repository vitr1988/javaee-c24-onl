package lesson37.dao.impl;

import lesson37.dao.ReportDao;
import lesson37.model.Report;
import lombok.extern.log4j.Log4j;

@Log4j
//@Component
//@Primary
public class ReportJpaDao implements ReportDao {

    @Override
    public void save(Report report) {
        log.info("Try to save as entity " + report);
    }
}
