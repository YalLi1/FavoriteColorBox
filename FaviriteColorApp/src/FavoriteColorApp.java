import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FavoriteColorApp extends JFrame {

    private JLabel resultLabel;
    private JComboBox<String> colorComboBox;
    private JButton answerButton;
    private JCheckBox customColorCheckBox;
    private JTextField customColorTextField;

    public FavoriteColorApp() {
        // Настройка фрейма
        setTitle("Favorite Color App");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание панели для размещения компонентов
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Создание JComboBox с любимыми цветами
        String[] colors = {"Красный", "Синий", "Зелёный", "Жёлтый", "Фиолетовый"};
        colorComboBox = new JComboBox<>(colors);
        colorComboBox.setMaximumSize(new Dimension(200, 30));

        // Создание JCheckBox и JTextField для пользовательского ввода цвета
        customColorCheckBox = new JCheckBox("Ввести свой цвет");
        customColorTextField = new JTextField();
        customColorTextField.setMaximumSize(new Dimension(200, 30));
        customColorTextField.setEnabled(false);

        customColorCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                customColorTextField.setEnabled(customColorCheckBox.isSelected());
            }
        });

        // Создание кнопки "Ответить"
        answerButton = new JButton("Ответить");
        answerButton.setMaximumSize(new Dimension(100, 30));
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor;
                if (customColorCheckBox.isSelected()) {
                    selectedColor = customColorTextField.getText();
                } else {
                    selectedColor = (String) colorComboBox.getSelectedItem();
                }
                resultLabel.setText("Ответ: " + selectedColor);
            }
        });

        // Создание метки для отображения ответа
        resultLabel = new JLabel("Ответ: ", SwingConstants.CENTER);

        // Добавление компонентов к панели
        panel.add(new JLabel("Выберите ваш любимый цвет:", SwingConstants.CENTER));
        panel.add(Box.createVerticalStrut(10));
        panel.add(colorComboBox);
        panel.add(Box.createVerticalStrut(10));
        panel.add(customColorCheckBox);
        panel.add(Box.createVerticalStrut(10));
        panel.add(customColorTextField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(answerButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(resultLabel);

        // Добавление панели к фрейму
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

}
