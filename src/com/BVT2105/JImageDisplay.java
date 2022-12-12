package com.BVT2105;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// Создание пользовательского интерфейса

// Создадим класс JImageDisplay, производный от JComponent
public class JImageDisplay extends JComponent {
    // создадим приватный класс управления изображением, содержимое которого можно записать
    private BufferedImage image;

    //Настроим конструктор, который должен принимать значения ширины и высоты, инициализировать объект BI новым
    // изображением с этой шириной и высотой и типом изображения TYPE_INT_RGB
    public JImageDisplay(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension dimension = new Dimension(width, height);
        super.setPreferredSize(dimension);
    }

    //Этот компонент выводит данные изображения на экран
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    //Очищает изображение, устанавливая все пиксели в черный цвет(RGB 0)
    public void clearImage() {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                drawPixel(i, j, 0);
            }
        }
    }

    //Устанавливает пиксель в определенный цвет
    public void drawPixel(int x, int y, int rgbColor) {
        image.setRGB(x, y, rgbColor);
    }

    //Возвращает метод для изображения
    public BufferedImage getImage() {
        return image;
    }
}