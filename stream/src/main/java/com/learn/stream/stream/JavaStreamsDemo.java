package com.learn.stream.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsDemo {

    public static void main(String[] args) {

        // Immutable list, allows nulls.
        var immutableList = Stream.of("red", "green", null).toList();
        // immutableList.add("yellow"); //this will throw error
        System.out.println("Immutable List: " + immutableList);

        // Modifiable list, allows nulls.
        var modifiableList = Stream.of("red", "green", null)
                .collect(Collectors.toList());
        modifiableList.add("yellow");
        modifiableList.set(2, "orange");
        System.out.println("Modifiable List: " + modifiableList);

        record Product(String name, String category, int price) {}

        // Define a Supplier for the products stream to create a new stream on each use
        Supplier<Stream<Product>> productsSupplier = () -> Stream.of(
                new Product("Laptop", "Electronics", 1000),
                new Product("TV", "Electronics", 1500),
                new Product("Sofa", "Furniture", 700),
                new Product("Table", "Furniture", 300),
                new Product("Lamp", "Home Decor", 50)
        );

        // Grouping products by category
        Map<String, List<Product>> groupProductsByCategory =
                productsSupplier.get().collect(Collectors.groupingBy(Product::category));
        System.out.println("Grouped by Category: " + groupProductsByCategory);

        // Aggregation: Calculating the total price of products by category
        Map<String, Integer> totalPriceByCategory =
                productsSupplier.get().collect(Collectors.groupingBy(Product::category,
                        Collectors.summingInt(Product::price)));
        System.out.println("Total Price by Category: " + totalPriceByCategory);

        // Aggregation: Calculating average price by category
        Map<String, Double> averagePriceByCategory =
                productsSupplier.get().collect(Collectors.groupingBy(Product::category,
                        Collectors.averagingInt(Product::price)));
        System.out.println("Average Price by Category: " + averagePriceByCategory);

        // Aggregation: Counting products by category
        Map<String, Long> countByCategory =
                productsSupplier.get().collect(Collectors.groupingBy(Product::category,
                        Collectors.counting()));
        System.out.println("Count by Category: " + countByCategory);

        // Filtering: Products with price greater than 1499
        var filteredProducts = productsSupplier.get()
                .filter(product -> product.price() > 1499)
                .toList();
        System.out.println("Filtered Products (price > 1499): " + filteredProducts);

        // Mapping: Extracting product categories
        var extractProductCategories = productsSupplier.get()
                .map(Product::category)
                .collect(Collectors.toList());
        System.out.println("Extracted Product Categories: " + extractProductCategories);

        // Partitioning: Separate products into expensive and cheap
        var partitionedProducts = productsSupplier.get()
                .collect(Collectors.partitioningBy(product -> product.price() > 1000));
        System.out.println("Partitioned Products (expensive > 1000): " + partitionedProducts);

        // Using SummaryStatistics for product prices by category
        Map<String, IntSummaryStatistics> summaryStatisticsByCategory =
                productsSupplier.get().collect(Collectors.groupingBy(Product::category,
                        Collectors.summarizingInt(Product::price)));
        System.out.println("Summary Statistics by Category: " + summaryStatisticsByCategory);
    }

}
