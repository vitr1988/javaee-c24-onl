package lesson31.adapter;

public class VirtualSystem {

    public static void main(String[] args) {
        ProcessingService processingService = new JsonProcessingService();
        String stringInJsonFormat = """
                [{
                    "field1": 125,
                    "flag1": true,
                    "number1": 1,
                    "str1": "hello"
                },
                {
                    "field1": 126,
                    "flag1": false,
                    "number1": 3,
                    "str1": "world"
                }, 
                {
                    "field1": 127,
                    "flag1": true,
                    "number1": -1,
                    "str1": "word"
                }]
                """;
        processingService.process(stringInJsonFormat);

        ProcessingService xmlProcessingService = new XmlProcessingService(new Xml2JsonConverter());
        xmlProcessingService.process("""
                <xml>
                    <fields>
                        <field>
                            <field1>125</field1>
                            <flag1>true</flag1>
                            <number1>1</number1>
                            <str1>hello</str1>
                        </field>
                        <field>
                            <field1>126</field1>
                            <flag1>false</flag1>
                            <number1>3</number1>
                            <str1>world</str1>
                        </field>
                        <field>
                            <field1>127</field1>
                            <flag1>true</flag1>
                            <number1>-1</number1>
                            <str1>word</str1>
                        </field>
                    </fields>
                </xml>
                """);
    }
}
