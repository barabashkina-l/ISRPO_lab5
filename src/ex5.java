import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ex5 {
    protected List<ElementTypes> addedElements = new ArrayList<>();
    protected int min_new_len = 1;
    protected int max_new_len = 5;
    private Random rand = new Random();
    protected JComponent getComponent(ElementTypes type, String text){
        return switch (type){
            case BUTTON -> new JButton(text);
            case FIELD -> new JTextField(text);
            case LABEL -> new JLabel(text);
            case RADIO_BUTTON -> new JRadioButton(text);
        };
    }

    protected int countInList(ElementTypes type){
        int res = 0;
        for (int i = 0; i < addedElements.size(); i++) {
            ElementTypes addedElement = addedElements.get(i);
            if (addedElement == type){
                res += 1;
            }
        }
        return res;
    }

    protected String getElementsCount(){
        String res = "";
        ElementTypes[] values = ElementTypes.values();
        for (int i = 0; i < values.length; i++) {
            ElementTypes value = values[i];
            String type_str = String.valueOf(value);
            if (type_str.length() < 10){
                type_str += "\t";
            }
            res += type_str + "\t" + countInList(value) + "\n";
        }
        return res;
    }
    public ex5() {


/*
Разработать программу, добавляющую на форму последовательность элементов управления случайной длины.
Тип элементов управления задается случайным образом.
Предусмотреть возможность вывода информации о количестве элементов по типам.
        */
        button.addActionListener(e -> {
            int len = rand.nextInt(min_new_len, max_new_len);
            for (int i = 0; i < len; i++) {
                ElementTypes[] possible_types = ElementTypes.values();
                int random_type_num = rand.nextInt(0, possible_types.length);
                ElementTypes randType = possible_types[random_type_num];

                JComponent newComponent = getComponent(randType, String.valueOf(addedElements.size()));
                dynamic_panel.add(newComponent);
                dynamic_panel.revalidate();
                dynamic_panel.repaint();
                addedElements.add(randType);
                textArea1.setText(getElementsCount());
            }

        });

        clearButton.addActionListener(e -> {
            dynamic_panel.removeAll();
            dynamic_panel.revalidate();
            dynamic_panel.repaint();
            addedElements.clear();
            textArea1.setText(getElementsCount());
        });
        textArea1.setText(getElementsCount());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ex5");
        frame.setContentPane(new ex5().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel root;
    private JButton button;
    private JPanel dynamic_panel;
    private JTextArea textArea1;
    private JButton clearButton;

}



