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

        pm.parseProduct("D,101,Tea,1.99,0,2021-09-21");
        pm.printProductReport(101);
        pm.parseReview("101,4,Nice hot cup of tea");
        pm.parseReview("101,2,Rather weak tea");
        pm.parseReview("101,4,Fine tea");
        pm.parseReview("101,4,Good tea");
        pm.parseReview("101,5,Perfect tea");
        pm.parseReview("101,3,Just add some lemon");
        pm.printProductReport(101);



    }
}

