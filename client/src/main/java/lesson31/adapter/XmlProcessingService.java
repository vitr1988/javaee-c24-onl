package lesson31.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class XmlProcessingService implements ProcessingService {

    private final Converter converter;

    @Override
    public Long process(String xml) {
        String json = converter.convert(xml);
//        return new ObjectMapper().parse(json).getMax();
        return null;
    }
}
