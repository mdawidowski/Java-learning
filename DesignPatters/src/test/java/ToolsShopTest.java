import queue.Client;
import org.junit.Before;
import org.junit.Test;
import queue.Queue;
import queue.QueueChecker;
import shoppingList.AbstractShoppingList;
import shoppingList.DiscountDecorator;
import shoppingList.NewProductDecorator;
import shoppingList.ShoppingList;
import toolShop.ToolShop;
import tools.Tool;
import tools.ToolBuilder;

import java.util.ArrayList;
import java.util.List;

public class ToolsShopTest {
    private ToolBuilder toolBuilder1;
    private ToolBuilder toolBuilder2;
    private ToolBuilder toolBuilder3;
    private ToolShop toolShop;

    @Before
    public void create_tools_shop(){
        toolShop = ToolShop.getInstance();
    }

    @Test
    public void build_tools_for_tools_shop(){
        this.toolBuilder1 = new ToolBuilder();
        this.toolBuilder2 = new ToolBuilder();
        this.toolBuilder3 = new ToolBuilder();

        Tool tool = toolBuilder1
                .withBrand("Neo")
                .withModel("08-254")
                .withName("Metal case")
                .withType("Boxes")
                .withPrice(20)
                .withQuantity(1)
                .buildTool();

        toolShop.addToolToToolShop(tool);

        tool = toolBuilder2
                .withBrand("Graphite")
                .withModel("59G207")
                .withName("Angle grinder")
                .withType("PowerTools")
                .withPower(2350)
                .withPrice(300)
                .buildTool();

        toolShop.addToolToToolShop(tool);

        tool = toolBuilder3
                .withBrand("Walmer")
                .withModel("MGM800")
                .withName("Tile cutting machine")
                .withType("Hand tools")
                .withPower(0)
                .withPrice(249)
                .withQuantity(2)
                .buildTool();

        toolShop.addToolToToolShop(tool);
        System.out.println(toolShop.getToolsList());

        Queue queue = new Queue();
        QueueChecker qc = new QueueChecker(1);
        Client client = new Client();
        client.addObserver(queue, qc);
        client.newClient(queue);

        AbstractShoppingList list;
        List<AbstractShoppingList> shoppingList = new ArrayList<>();
        list = new ShoppingList();
        shoppingList.add(list);
        list = new NewProductDecorator(list, toolShop.getToolFromToolsList("Walmer"));
        list = new NewProductDecorator(list, toolShop.getToolFromToolsList("Graphite"));
        System.out.println(list);
        list = new DiscountDecorator(list, 30);
        System.out.println(list);
        client.clientLeft(queue);
    }
}
