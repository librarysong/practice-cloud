package cn.swf.practice.practicemaster.excel;

import cn.swf.practice.practicemaster.bean.Consultant;
import cn.swf.practice.practicemaster.bean.TradeOrder;
import com.alibaba.fastjson.JSON;
import com.github.liuhuagui.gridexcel.GridExcel;
import com.github.liuhuagui.gridexcel.eventmodel.XLSEventModel;
import com.github.liuhuagui.gridexcel.util.ExcelType;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by 宋维飞
 * 2019/10/20 13:18
 */
@RestController
public class ReadTest {

    @RequestMapping("/excel2003")
    public void xlsEventModel() throws IOException {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("2003.xls");
        ArrayList<TradeOrder> arrayList = new ArrayList<>();
        XLSEventModel xls = new XLSEventModel(resourceAsStream, 1, cs -> {
            TradeOrder tradeOrder = new TradeOrder();
            tradeOrder.setTradeOrderId(Long.valueOf(cs.get(0)));
            Consultant consultant = new Consultant();
            consultant.setConsultantName(cs.get(3));
            tradeOrder.setConsultant(consultant);
            tradeOrder.setPaymentRatio(cs.get(16));
            arrayList.add(tradeOrder);
        });
        xls.process();
        System.out.println(JSON.toJSONString(arrayList));
    }

    public void xlsxEventModel() throws IOException, OpenXML4JException, ParserConfigurationException, SAXException {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("2007.xlsx");
        ArrayList<TradeOrder> arrayList = new ArrayList<>();
        XLSEventModel xlsx = new XLSEventModel(resourceAsStream, 1, cs -> {
            TradeOrder tradeOrder = new TradeOrder();
            tradeOrder.setTradeOrderId(Long.valueOf(cs.get(0)));
            Consultant consultant = new Consultant();
            consultant.setConsultantName(cs.get(3));
            tradeOrder.setConsultant(consultant);
            tradeOrder.setPaymentRatio(cs.get(16));
            arrayList.add(tradeOrder);
        });
        xlsx.process();
        System.out.println(JSON.toJSONString(arrayList));
    }

    public void readXlsByEventModel() throws Exception {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("2003.xls");
        GridExcel.readByEventModel(resourceAsStream, TradeOrder.class, ExcelType.XLS)
                .window(2, ts -> System.out.println(JSON.toJSONString(ts)))
                .process(cs -> {
                    TradeOrder tradeOrder = new TradeOrder();
                    tradeOrder.setTradeOrderId(Long.valueOf(cs.get(0)));
                    Consultant consultant = new Consultant();
                    consultant.setConsultantName(cs.get(3));
                    tradeOrder.setConsultant(consultant);
                    tradeOrder.setPaymentRatio(cs.get(16));
                    return tradeOrder;
                }, 1);
    }
}
