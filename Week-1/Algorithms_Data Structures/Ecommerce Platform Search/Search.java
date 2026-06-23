class Search {
    public static void linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                System.out.println("ID: " + p.productId + ", Name: " + p.productName + ", Category: " + p.category);
                return;
            }
        }
        System.out.println("Product NOT found");
    }

    // Products must be Sorted
    public static void binarySearch(Product[] products, String name) {
        int l = 0, r = products.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            Product p = products[mid];
            int cmp = p.productName.compareToIgnoreCase(name);

            if (cmp == 0) {
                System.out.println("ID: " + p.productId + ", Name: " + p.productName + ", Category: " + p.category);
                return;
            }
            else if (cmp < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        System.out.println("Product NOT found");
    }
}
