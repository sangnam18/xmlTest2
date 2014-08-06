import java.io.StringReader;

import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
 
 
public class XPathTest{
    public static void main(String[] args) throws Exception {
       /* String xml = "<root><row><col1 id='c1'>값1</col1><col2 id='c2' val='val2'>값2</col2></row>" + 
                             "<row><col1 id='c3'>값3</col1><col2 id='c4'>값4</col2></row></root>";
    	String chunXml = "<root><row><STATUS_TEXT>값1 춘성 테스트</STATUS_TEXT><col2 id='c2' val='val2'>값2</col2></row>" + 
                "<row><col1 id='c3'>값3</col1><col2 id='c4'>값4</col2></row></root>";
         
        // XML Document 객체 생성
        //InputSource is = new InputSource(new StringReader(xml));
    	InputSource is = new InputSource(new StringReader(chunXml));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
 
        // 인터넷 상의 XML 문서는 요렇게 생성하면 편리함.
        //Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        //                               .parse("http://www.example.com/test.xml");
         
         
         
        // xpath 생성
        XPath xpath = XPathFactory.newInstance().newXPath();
         
        NodeList colsTest = (NodeList)xpath.evaluate("/row/STATUS_TEXT[1]", document, XPathConstants.NODESET);
        System.out.println("값 test : "+ colsTest);
         
         
        // NodeList 가져오기 : row 아래에 있는 모든 col1 을 선택
        NodeList cols = (NodeList)xpath.evaluate("//row/col1", document, XPathConstants.NODESET);
        for( int idx=0; idx<cols.getLength(); idx++ ){
            System.out.println(cols.item(idx).getTextContent());
        }
        // 값1   값3  이 출력됨
         
         
        // id 가 c2 인 Node의 val attribute 값 가져오기
        Node col2 = (Node)xpath.evaluate("//*[@id='c2']", document, XPathConstants.NODE);
        System.out.println(col2.getAttributes().getNamedItem("val").getTextContent());
        // val2 출력
         
        // id 가 c3 인 Node 의 value 값 가져오기
        System.out.println(xpath.evaluate("//*[@id='c3']", document, XPathConstants.STRING));
        // 값3 출력
*/        
               try { 
            	   
                StringBuffer sb      =  new StringBuffer();
                sb.append("<?xml version=\"1.0\" encoding=\"EUC-KR\"?>");
                sb.append("<response>");
                sb.append(" <response_header>");
                sb.append("<version>2.0</version>");
                sb.append("<primitive_type>SUBSCRIPTION_NOTIFICATION_RESPONSE</primitive_type>");
                sb.append("<transaction_id>537844880</transaction_id>");
                sb.append("<connection_id>CPTET_23000320</connection_id>");
                sb.append("</response_header>");
                sb.append("<subscription_notification_response>");
                sb.append("<message_id>123412341234134_293</message_id>");
                sb.append("<user_info_result>");
                sb.append("<user_info>");
                sb.append("<type>MDN</type>");
                sb.append("<id>0117991370</id>");
                sb.append(" </user_info>");
                sb.append("  <status>16</status>");
                sb.append("  <status_text>양춘성님</status_text>");
                sb.append("</user_info_result>");
                sb.append("</subscription_notification_response>");
                sb.append("</response>");
                
                
                
                DocumentBuilderFactory factory  =  DocumentBuilderFactory.newInstance();
                DocumentBuilder builder    =  factory.newDocumentBuilder();
                //Document document     =  builder.parse("c:/person.xml");
                
                //*****************************************************
                Document document     =  builder.parse(new InputSource(new StringReader(sb.toString())));
                //여기가 핵심 *******************************************
                
                NodeList nodelist1     =  document.getElementsByTagName("status");
                //태그 (< >)의 이름으로 불러오는 내용                
                
                //nodelist의 크기를 구하려면 getLength()라는 메소드가 있음                
                Node node       =  nodelist1.item(0);//첫번째 element 얻기                
                Node textNode      =  nodelist1.item(0).getChildNodes().item(0);
                
                
                NodeList nodelist2     =  document.getElementsByTagName("status_text");                
                Node node2       =  nodelist2.item(0);//첫번째 element 얻기                
                Node textNode2      =  nodelist2.item(0).getChildNodes().item(0);
                
                
                //element의 text 얻기                
                System.out.println("status : "+textNode.getNodeValue());
                System.out.println("status_text : "+textNode2.getNodeValue());
                
                
               }catch(Exception e){
                e.printStackTrace();
                
               
               }
    }
}