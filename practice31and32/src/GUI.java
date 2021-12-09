import CustomerInfo.Address;
import CustomerInfo.Customer;
import Orders.InternetOrder;
import Items.MenuItem;
import Orders.Order;
import Orders.TableOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI extends JFrame {
    private Controller controller;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JList InternetMenu;
    private JList CurrentOrderInternet;
    private JList InternetList;
    private JButton addButtonInternet;
    private JButton removeButtonInternet;
    private JButton createOrderButtonInternet;
    private JButton detailsButtonInternet;
    private JButton addButtonRestaurant;
    private JButton removeButtonRestaurant;
    private JButton createOrderButtonRestaurant;
    private JButton detailsButtonRestaurant;
    private JList RestaurantMenu;
    private JList CurrentOrderMenu;
    private JList RestaurantList;
    private JScrollPane InternetMenuPane;
    private JScrollPane CurrentOrderInternetPane;
    private JScrollPane ListOfOrdersPane;
    private JPanel InternetButtonPanel;
    private JPanel RestaurantButtonPanel;
    private JScrollPane RestaurantMenuPane;
    private JScrollPane CurrentOrderRestaurantPane;
    private JScrollPane ListOfOrdersRestaurantPane;

    public GUI() {
        super("Restaurant");
        controller = new Controller();
        setSize(800, 600);
        setUI();
        setContentPane(panel1);
        setVisible(true);
    }

    public void setUI() {
        panel1 = new JPanel();
        panel1.setLayout(new CardLayout(0, 0));
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, "Card1");
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Internet Orders", panel2);
        InternetMenuPane = new JScrollPane();
        InternetMenuPane.setAutoscrolls(false);
        InternetMenuPane.setVerticalScrollBarPolicy(22);

        panel2.add(InternetMenuPane, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        DefaultListModel defaultListModel1 = new DefaultListModel();
        for (Items.MenuItem item:controller.getMenu()){
            defaultListModel1.addElement(item);
        }
        InternetMenu = new JList(defaultListModel1);
        InternetMenu.setModel(defaultListModel1);
        InternetMenuPane.setViewportView(InternetMenu);


        CurrentOrderInternetPane = new JScrollPane();
        CurrentOrderInternetPane.setVerticalScrollBarPolicy(22);
        panel2.add(CurrentOrderInternetPane, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        DefaultListModel defaultListModel2 = new DefaultListModel();
        CurrentOrderInternet = new JList(defaultListModel2);
        CurrentOrderInternetPane.setViewportView(CurrentOrderInternet);



        ListOfOrdersPane = new JScrollPane();
        ListOfOrdersPane.setVerticalScrollBarPolicy(22);
        panel2.add(ListOfOrdersPane, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        DefaultListModel defaultListModel3 = new DefaultListModel();
        InternetList = new JList(defaultListModel3);
        ListOfOrdersPane.setViewportView(InternetList);


        InternetButtonPanel = new JPanel();
        InternetButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(InternetButtonPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        addButtonInternet = new JButton();
        addButtonInternet.setText("Add");
        InternetButtonPanel.add(addButtonInternet);
        addButtonInternet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selected = InternetMenu.getSelectedIndices();
                for (int i = 0; i<selected.length;i++){
                    defaultListModel2.addElement(InternetMenu.getModel().getElementAt(selected[i]));
                }
            }
        });

        removeButtonInternet = new JButton();
        removeButtonInternet.setText("Remove");
        InternetButtonPanel.add(removeButtonInternet);
        removeButtonInternet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selected = CurrentOrderInternet.getSelectedIndices();
                for (int i = 0; i<selected.length;i++){
                    defaultListModel2.removeElementAt(selected[i]);
                }
            }
        });

        createOrderButtonInternet = new JButton();
        createOrderButtonInternet.setText("Create Order");
        InternetButtonPanel.add(createOrderButtonInternet);
        createOrderButtonInternet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuItem[] item = new MenuItem[CurrentOrderInternet.getModel().getSize()];
                for (int i = 0; i < CurrentOrderInternet.getModel().getSize();i++){
                    item[i] = (MenuItem) defaultListModel2.getElementAt(i);

                }
                defaultListModel2.removeAllElements();
                String customerName = JOptionPane.showInputDialog(GUI.this,"Введите свою Фамилию и Имя",JOptionPane.QUESTION_MESSAGE);
                String customerAddress = JOptionPane.showInputDialog(GUI.this,"Введите адрес(улицу,дом,квартиру) через ;");
                String[] addressParse = customerAddress.split(";");
                String[] FI = customerName.split(" ");
                if (addressParse.length == 3 && FI.length == 2) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(addressParse[1]);
                    while (matcher.find()) {
                        addressParse[1] = addressParse[1].substring(matcher.start(), matcher.end());
                    }
                    matcher = pattern.matcher(addressParse[2]);
                    while (matcher.find()) {
                        addressParse[2] = addressParse[2].substring(matcher.start(), matcher.end());
                    }
                    Address address = new Address("Москва",127042,addressParse[0],Integer.parseInt(addressParse[1]),'\0',Integer.parseInt(addressParse[2]));
                    Customer customer = new Customer(FI[0],FI[1],18,address);
                    InternetOrder order = new InternetOrder(item);
                    order.setCustomer(customer);
                    controller.getInternetOrdersManager().add(order);
                    defaultListModel3.addElement(customer);
                }
            }
        });

        detailsButtonInternet = new JButton();
        detailsButtonInternet.setText("Details");
        InternetButtonPanel.add(detailsButtonInternet);
        detailsButtonInternet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = InternetList.getSelectedIndex();
                Customer customer = (Customer) defaultListModel3.getElementAt(index);
                Order order = controller.getInternetOrdersManager().getOrder(customer.getAddress());
                int cost = order.costTotal();
                String message = "Total cost: " + cost +"\nPurchased items: ";
                for (int i = 0; i<order.itemsQuantity();i++){
                    if (i != order.itemsQuantity()-1)
                        message+=order.getItems()[i]+", ";
                    else
                        message += order.getItems()[i]+".";
                }
                JOptionPane.showMessageDialog(new Frame(),message);
            }
        });
        final JLabel label1 = new JLabel();
        label1.setText("Menu");
        panel2.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Current Order");
        panel2.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("List of Orders(By Address)");
        panel2.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Restaurant Orders", panel3);
        final JLabel label4 = new JLabel();
        label4.setText("Menu");
        panel3.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Current Order");
        panel3.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("List of Order(By Table Number)");
        panel3.add(label6, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        RestaurantMenuPane = new JScrollPane();
        RestaurantMenuPane.setVerticalScrollBarPolicy(22);
        panel3.add(RestaurantMenuPane, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        DefaultListModel defaultListModel4 = new DefaultListModel();
        RestaurantMenu = new JList(defaultListModel4);
        RestaurantMenuPane.setViewportView(RestaurantMenu);
        for (Items.MenuItem item:controller.getMenu()){
            defaultListModel4.addElement(item);
        }

        CurrentOrderRestaurantPane = new JScrollPane();
        CurrentOrderRestaurantPane.setVerticalScrollBarPolicy(22);
        panel3.add(CurrentOrderRestaurantPane, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        DefaultListModel defaultListModel5 = new DefaultListModel();
        CurrentOrderMenu = new JList(defaultListModel5);
        CurrentOrderRestaurantPane.setViewportView(CurrentOrderMenu);

        ListOfOrdersRestaurantPane = new JScrollPane();
        ListOfOrdersRestaurantPane.setVerticalScrollBarPolicy(22);
        panel3.add(ListOfOrdersRestaurantPane, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        DefaultListModel defaultListModel6 = new DefaultListModel();
        RestaurantList = new JList(defaultListModel6);
        ListOfOrdersRestaurantPane.setViewportView(RestaurantList);

        RestaurantButtonPanel = new JPanel();
        RestaurantButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel3.add(RestaurantButtonPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        addButtonRestaurant = new JButton();
        addButtonRestaurant.setText("Add");
        RestaurantButtonPanel.add(addButtonRestaurant);
        addButtonRestaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selected = RestaurantMenu.getSelectedIndices();
                    for (int i = 0; i < selected.length;i++){
                        defaultListModel5.addElement(RestaurantMenu.getModel().getElementAt(selected[i]));
                    }
                }
        });

        removeButtonRestaurant = new JButton();
        removeButtonRestaurant.setText("Remove");
        RestaurantButtonPanel.add(removeButtonRestaurant);
        removeButtonRestaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selected = CurrentOrderMenu.getSelectedIndices();
                for (int i = 0; i < selected.length;i++){
                    defaultListModel5.removeElementAt(selected[i]);
                }
            }
        });

        createOrderButtonRestaurant = new JButton();
        createOrderButtonRestaurant.setText("Create Order");
        RestaurantButtonPanel.add(createOrderButtonRestaurant);
        createOrderButtonRestaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuItem[] item = new MenuItem[CurrentOrderMenu.getModel().getSize()];
                for (int i = 0; i < CurrentOrderMenu.getModel().getSize();i++){
                    item[i] = (MenuItem) defaultListModel5.getElementAt(i);

                }
                defaultListModel5.removeAllElements();
                String table = JOptionPane.showInputDialog(GUI.this,"Введите номер свободного столика, чтобы добавить заказ" +
                        "(номера от 1 до 20)",JOptionPane.QUESTION_MESSAGE);
                //Table info input
                int tableNumber = Integer.parseInt(table);
                //int tableNumber = controller.getTableOrdersManager().freeTableNumber();
                controller.getTableOrdersManager().add(new TableOrder(item),tableNumber);
                defaultListModel6.addElement(tableNumber);
            }
        });

        detailsButtonRestaurant = new JButton();
        detailsButtonRestaurant.setText("Details");
        RestaurantButtonPanel.add(detailsButtonRestaurant);
        detailsButtonRestaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = RestaurantList.getSelectedIndex();
                int table = Integer.parseInt(defaultListModel6.getElementAt(index).toString());
                Order order = controller.getTableOrdersManager().getOrder(table);
                int cost = order.costTotal();
                String message = "Total cost: " + cost +"\nPurchased items: ";
                for (int i = 0; i<order.itemsQuantity();i++){
                    if (i != order.itemsQuantity()-1)
                        message+=order.getItems()[i]+", ";
                    else
                        message += order.getItems()[i]+".";
                }
                JOptionPane.showMessageDialog(new Frame(),message);
            }
        });
    }


}
