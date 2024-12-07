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

package labs.pm.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

/**
 * {@code Product} class represents properties and behaviors of
 * product objects in the Product Management System.
 * <br>
 * Each product has an id, name, and price
 * <br>
 * Each product can have a discount, calculated based on a
 * {@link #DISCOUNT_RATE discount rate}
 * @version 4.0
 * author marwa
 **/

public sealed abstract class Product implements Rateable<Product> permits Food, Drink{
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private final int id;
    private final String name;
    private final BigDecimal price;
    public final Rating rating;

    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

//    public Product(int id, String name, BigDecimal price) {
//
//        this(id, name, price, Rating.NOT_RATED);
//    }
//
//    public Product(){
//
//        this(0, "no name", BigDecimal.ZERO);
//    }

    /**
     * A constant that defines a
     * {@link java.math.BigDecimal BigDecimal} value of the discount rate
     * <br>
     * Discount rate is 10%
     **/

    public int getId() {

        return id;
    }

//    public void setId(final int id) {
//        this.id = id;
//    }

    public String getName() {

        return name;
    }

//    public void setName(final String name) {
//        this.name = name;
//    }

    public BigDecimal getPrice() {

        return price;
    }

//    public void setPrice(final BigDecimal price) {
//        this.price = price;
//    }

    /**
     * Calculates discount based on a product price and
     * {@link #DISCOUNT_RATE discount rate}
     * @return a {@link java.math.BigDecimal BigDecimal}
     * value of the discount
     **/
    public BigDecimal getDiscount() {

        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public Rating getRating() {

        return rating;
    }
    public abstract Product applyRating(Rating newRating);

    /**
     * Assumes that the best before date is today
     * @return the current date
     **/
    public LocalDate getBestBefore() {

        return LocalDate.now();
    }

    @Override
    public String toString() {

        return id+", "+name+", "+price+", "+getDiscount()+", "+rating.getStars()+" "+getBestBefore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
        if(o instanceof Product product) {
            return id == product.id; //&& Objects.equals(name, product.name);
        }
        return false;
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(id);
    }
}
