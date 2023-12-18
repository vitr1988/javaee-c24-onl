package lesson37.dao.impl;

import lesson37.dao.ReportDao;
import lesson37.model.Report;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Log4j
@Component("defaultReportDao")
//@Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
@Scope(value = "prototype")
public class ReportJdbcDao implements ReportDao {

    @Getter
    @Value("${hello}")
//    @Autowired
    private String hello;

    @Getter
    @Value("${settings.maxValue}")
    private Integer maxValue;

    @Getter
    @Value("${path}")
    private String path;

    @Override
    public void save(Report report) {
        log.info("Try to save report " + report);
    }

//    @Autowired
//    public void setHello(@Value("${hello}") String hello) {
//        this.hello = hello;
//    }
}
