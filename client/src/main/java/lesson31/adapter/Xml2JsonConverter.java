package lesson31.adapter;

public class Xml2JsonConverter implements Converter {
    @Override
    public String convert(String str) { // на входе xml, на выходе будет json
        return str;
    }
}
