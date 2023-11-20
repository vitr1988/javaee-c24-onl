package lesson31.adapter;

public class JsonProcessingService implements ProcessingService {

    @Override
    public Long process(String jsonFormat) {
//        return new ObjectMapper().parse(jsonFormat).getMax();
        return null;
    }
}
