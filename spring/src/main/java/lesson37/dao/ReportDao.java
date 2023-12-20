package lesson37.dao;

import lesson37.model.Report;

public interface ReportDao {

    void save(Report report);

    String getBeanName();

//    String getHello();

}
