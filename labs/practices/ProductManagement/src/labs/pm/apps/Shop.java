/*
 * License along with this program.
 * <http://www.gnu.org/licenses/>.
 *
 * Copyright (c)  2024.
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * If not, see<http://www.gnu.org/licenses/>
 */

package labs.pm.apps;

import labs.pm.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


/**
 * {@code Shop} class represents an application that manages Products
 * @version 4.0
 * @author marwan
**/
public class Shop {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager("en-GB");

        pm.createProduct(101, "Tea",
                BigDecimal.valueOf(1.99), Rating.NOT_RATED, LocalDate.now());
        pm.printProductReport(101);
        pm.reviewProduct(101, Rating.FOUR_STAR,
                "Nice not cup of tea");
        pm.reviewProduct(101, Rating.TWO_STAR,
                "Rather weak tea");
        pm.reviewProduct(101, Rating.FOUR_STAR,
                "Fine tea");
        pm.reviewProduct(101, Rating.FOUR_STAR,
                "Good tea");
        pm.reviewProduct(101, Rating.FIVE_STAR,
                "Perfect tea");
        pm.reviewProduct(101, Rating.THREE_STAR,
                "Just add some lemon");
//        pm.printProductReport(101);

//        pm.changeLocale("ru-RU");
        pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99),
                Rating.NOT_RATED);
        pm.reviewProduct(102, Rating.THREE_STAR, "Coffee was ok");
        pm.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?!");
        pm.reviewProduct(102, Rating.FIVE_STAR,
                "It's perfect with ten spoons of sugar!");
//        pm.printProductReport(102);


        pm.createProduct(103, "Cake",
                BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
        pm.reviewProduct(103, Rating.FIVE_STAR,
                "Very nice cake");
        pm.reviewProduct(103, Rating.FOUR_STAR,
                "Good, but I've expected more chocolate");
        pm.reviewProduct(103, Rating.FIVE_STAR,
                "This cake is perfect!");
//        pm.printProductReport(103);


//        pm.changeLocale("fr-FR");
        pm.createProduct(104, "Cookie",
                BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now());
        pm.reviewProduct(104, Rating.THREE_STAR,
                "Just another cookie");
        pm.reviewProduct(104, Rating.THREE_STAR,
                "Ok");
//        pm.printProductReport(104);


        pm.createProduct(105, "Hot Chocolate",
                BigDecimal.valueOf(2.50), Rating.NOT_RATED);
        pm.reviewProduct(105, Rating.FOUR_STAR,
                "Tasty!");
        pm.reviewProduct(105, Rating.FOUR_STAR,
                "Not bad at all");
//        pm.printProductReport(105);


        pm.createProduct(106, "Chocolate",
                BigDecimal.valueOf(2.50), Rating.NOT_RATED, LocalDate.now().plusDays(3));
        pm.reviewProduct(106, Rating.TWO_STAR,
                "Too sweet");
        pm.reviewProduct(106, Rating.THREE_STAR,
                "Better than cookie");
        pm.reviewProduct(106, Rating.TWO_STAR,
                "Too bitter");
        pm.reviewProduct(106, Rating.ONE_STAR,
                "I don't get it!");
//        pm.printProductReport(106);

        Comparator<Product> ratingSorter = (p1, p2) ->
                p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1, p2) ->
                p2.getPrice().compareTo(p1.getPrice());
        pm.printProducts(ratingSorter.thenComparing(priceSorter));
        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
        pm.printProducts((p1, p2) ->
                p2.getRating().ordinal() - p1.getRating().ordinal());
        pm.printProducts((p1, p2) ->
                p2.getPrice().compareTo(p1.getPrice()));


    }
}

