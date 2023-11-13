package by.teachmeskills.lesson27.tag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Objects;

public class HelloTag extends TagSupport {

    @Getter
    @Setter
    private String name;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("Hello, %s".formatted(Objects.toString(name, "World")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }



    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
