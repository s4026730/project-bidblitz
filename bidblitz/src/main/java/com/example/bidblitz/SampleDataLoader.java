package com.example.bidblitz;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.*;
import com.example.bidblitz.repository.*;
import com.example.bidblitz.util.DatabaseUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class SampleDataLoader {

    public static void loadSampleData() {
        EntityManager em = DatabaseUtil.getEntityManager();
        try {
            long userCount = em.createQuery("SELECT COUNT(u) FROM User u", Long.class).getSingleResult();
            if (userCount > 0) {
                System.out.println("Sample data already loaded. Skipping.");
                return;
            }
        } finally {
            em.close();
        }

        System.out.println("Loading sample data...");
        loadCategories();
        loadUsers();
        loadItemsAndAuctions();
        System.out.println("Sample data loaded successfully.");
    }

    private static void loadCategories() {
        CategoryRepository repo = new CategoryRepository();
        // Main categories
        repo.add(new Category("Electronics",             "Electronic devices and accessories",     4.5));
        repo.add(new Category("Technologies",            "Tech products and components",           4.5));
        repo.add(new Category("Foods and Kitchen Tools", "Food items and kitchen equipment",       3.5));
        repo.add(new Category("Fashions",                "Clothing and fashion accessories",       5.0));
        // Electronics sub categories
        repo.add(new Category("Smart Televisions",       "Smart TVs and displays",                4.5));
        repo.add(new Category("Wearables",               "Smartwatches and wearable devices",     4.5));
        repo.add(new Category("Networking Products",     "Routers switches and networking gear",   4.0));
        repo.add(new Category("Digital Storage",         "SSDs HDDs and memory cards",            4.0));
        repo.add(new Category("Electronic Circuits",     "Circuit boards and components",          4.0));
        repo.add(new Category("Repair Manuals",          "Technical repair guides and manuals",    3.0));
        // Technologies sub categories
        repo.add(new Category("Computers",               "Laptops and desktop computers",          4.5));
        repo.add(new Category("Mobile Phones",           "Smartphones and accessories",            4.5));
        repo.add(new Category("Tablets",                 "Tablets and e-readers",                  4.5));
        repo.add(new Category("Computer Parts",          "CPUs GPUs and computer components",      4.5));
        repo.add(new Category("Mobile Phone Parts",      "Phone screens batteries and parts",      4.0));
        repo.add(new Category("Tablet Parts",            "Tablet screens and accessories",         4.0));
        // Foods and Kitchen Tools sub categories
        repo.add(new Category("Meats",                   "Fresh and processed meats",              3.0));
        repo.add(new Category("Vegetables",              "Fresh vegetables and produce",           3.0));
        repo.add(new Category("Ingredients",             "Cooking ingredients and spices",         3.0));
        repo.add(new Category("Kitchen Tools",           "Utensils and kitchen gadgets",           3.5));
        repo.add(new Category("Cookwares",               "Pots pans and cooking equipment",        3.5));
        repo.add(new Category("Cooking Books",           "Recipe books and cooking guides",        3.0));
        // Fashions sub categories
        repo.add(new Category("Male Tops",               "Men shirts t-shirts and tops",           5.0));
        repo.add(new Category("Female Tops",             "Women shirts blouses and tops",          5.0));
        repo.add(new Category("Pants",                   "Jeans trousers and shorts",              5.0));
        repo.add(new Category("Skirts",                  "Mini midi and maxi skirts",              5.0));
        repo.add(new Category("Clothing Accessories",    "Belts bags and fashion accessories",     5.0));
        repo.add(new Category("Shoes",                   "Sneakers heels and footwear",            5.0));
    }

    private static void loadUsers() {
        UserRepository repo = new UserRepository();
        repo.add(new User("Nguyen Van An",   LocalDateTime.of(1990,3,15,0,0),  "vanan@gmail.com",    "0901234561", "vanan",     "pass123", User.ROLE_USER,         15000000));
        repo.add(new User("Tran Thi Binh",  LocalDateTime.of(1985,7,22,0,0),  "thibinh@gmail.com",  "0901234562", "thibinh",   "pass123", User.ROLE_USER,         8500000));
        repo.add(new User("Le Hoang Nam",   LocalDateTime.of(1992,11,8,0,0),  "hoangnam@gmail.com", "0901234563", "hoangnam",  "pass123", User.ROLE_USER,         22000000));
        repo.add(new User("Pham Thi Lan",   LocalDateTime.of(1988,4,30,0,0),  "thilan@gmail.com",   "0901234564", "thilan",    "pass123", User.ROLE_USER,         3200000));
        repo.add(new User("Hoang Van Duc",  LocalDateTime.of(1995,9,14,0,0),  "vanduc@gmail.com",   "0901234565", "vanduc",    "pass123", User.ROLE_USER,         50000000));
        repo.add(new User("Vo Thi Mai",     LocalDateTime.of(1983,12,1,0,0),  "thimai@gmail.com",   "0901234566", "thimai",    "pass123", User.ROLE_USER,         11000000));
        repo.add(new User("Dang Minh Tuan", LocalDateTime.of(1997,6,25,0,0),  "minhtuan@gmail.com", "0901234567", "minhtuan",  "pass123", User.ROLE_USER,         7500000));
        repo.add(new User("Bui Thi Thu",    LocalDateTime.of(1980,2,18,0,0),  "thithu@gmail.com",   "0901234568", "thithu",    "pass123", User.ROLE_USER,         33000000));
        repo.add(new User("Do Van Hung",    LocalDateTime.of(1993,8,5,0,0),   "vanhung@gmail.com",  "0901234569", "vanhung",   "pass123", User.ROLE_USER,         6000000));
        repo.add(new User("Nguyen Thi Hoa", LocalDateTime.of(1991,1,12,0,0),  "thihoa@gmail.com",   "0901234570", "thihoa",    "pass123", User.ROLE_USER,         18000000));
        repo.add(new User("Tran Van Long",  LocalDateTime.of(1987,5,20,0,0),  "vanlong@gmail.com",  "0901234571", "vanlong",   "pass123", User.ROLE_USER,         4200000));
        repo.add(new User("Le Thi Phuong",  LocalDateTime.of(1999,10,3,0,0),  "thiphuong@gmail.com","0901234572", "thiphuong", "pass123", User.ROLE_USER,         9000000));
        repo.add(new User("Pham Van Khanh", LocalDateTime.of(1994,3,28,0,0),  "vankhanh@gmail.com", "0901234573", "vankhanh",  "pass123", User.ROLE_USER,         27500000));
        repo.add(new User("Hoang Thi Yen",  LocalDateTime.of(1986,7,9,0,0),   "thiyen@gmail.com",   "0901234574", "thiyen",    "pass123", User.ROLE_USER,         13500000));
        repo.add(new User("Vo Van Thanh",   LocalDateTime.of(1998,12,17,0,0), "vanthanh@gmail.com", "0901234575", "vanthanh",  "pass123", User.ROLE_USER,         6800000));
        repo.add(new User("admin",          LocalDateTime.of(1985,1,1,0,0),   "admin@bidblitz.com", "0900000001", "admin",     "admin123",User.ROLE_SYSTEM_ADMIN,  0));
        repo.add(new User("auctionadmin",   LocalDateTime.of(1990,1,1,0,0),   "aadmin@bidblitz.com","0900000002", "aadmin",    "admin123",User.ROLE_AUCTION_ADMIN, 0));
    }

    private static void loadItemsAndAuctions() {
        UserRepository userRepo = new UserRepository();
        CategoryRepository catRepo = new CategoryRepository();
        ItemRepository itemRepo = new ItemRepository();
        AuctionRepository auctionRepo = new AuctionRepository();

        List<User> users = userRepo.findAll();
        List<Category> cats = catRepo.findAll();

        if (users.isEmpty() || cats.isEmpty()) return;

        User u1 = users.get(0);
        User u2 = users.get(1);
        User u3 = users.get(2);
        User u4 = users.get(3);
        User u5 = users.get(4);
        User u6 = users.get(5);
        User u7 = users.get(6);
        User u8 = users.get(7);

        // get categories by index matching loadCategories order
        Category electronics   = cats.get(0);  // Electronics
        Category technologies  = cats.get(1);  // Technologies
        Category foodsKitchen  = cats.get(2);  // Foods and Kitchen Tools
        Category fashions      = cats.get(3);  // Fashions
        Category computers     = cats.get(10); // Computers
        Category mobilePhones  = cats.get(11); // Mobile Phones
        Category meats         = cats.get(16); // Meats
        Category kitchenTools  = cats.get(19); // Kitchen Tools
        Category maleTops      = cats.get(22); // Male Tops
        Category shoes         = cats.get(27); // Shoes

        // past SOLD items
        Item i1  = new Item("MacBook Pro M3",        "M3 chip 16GB RAM 512GB SSD",          computers,    28000000, 30000000, "Used",        LocalDateTime.of(2025,1,1,9,0),  LocalDateTime.of(2025,1,10,18,0), u1);
        Item i2  = new Item("Adidas Running Shoes",  "Size 42 white lightweight",            shoes,          350000,   500000, "Used",        LocalDateTime.of(2025,1,2,10,0), LocalDateTime.of(2025,1,12,20,0), u3);
        Item i3  = new Item("Philips Blender",       "1200W 12 month warranty",              kitchenTools, 1200000,  1500000, "New",         LocalDateTime.of(2025,1,3,8,0),  LocalDateTime.of(2025,1,13,18,0), u5);
        Item i4  = new Item("Samsung Galaxy S24",    "256GB Phantom Black",                  mobilePhones,12000000, 13000000, "Used",        LocalDateTime.of(2025,1,4,11,0), LocalDateTime.of(2025,1,14,17,0), u8);
        Item i5  = new Item("Nike Polo Shirt",       "Size L dark navy classic fit",         maleTops,      400000,   600000, "Used",        LocalDateTime.of(2025,1,5,9,0),  LocalDateTime.of(2025,1,15,21,0), u2);
        Item i6  = new Item("Fresh Wagyu Beef 1kg",  "Grade A5 imported from Japan",         meats,         800000,  1000000, "New",         LocalDateTime.of(2025,1,6,10,0), LocalDateTime.of(2025,1,16,19,0), u7);
        Item i7  = new Item("Dell XPS 15",           "Intel i7 32GB RAM 1TB SSD",            computers,   25000000, 28000000, "Used",        LocalDateTime.of(2025,1,7,8,0),  LocalDateTime.of(2025,1,17,18,0), u4);
        Item i8  = new Item("LG OLED 55 inch TV",   "4K Smart TV with WebOS",               electronics, 15000000, 18000000, "New",         LocalDateTime.of(2025,1,8,12,0), LocalDateTime.of(2025,1,18,20,0), u3);
        Item i9  = new Item("iPad Pro 12.9",         "M2 chip 256GB WiFi",                   technologies,18000000, 20000000, "Used",        LocalDateTime.of(2025,1,9,9,0),  LocalDateTime.of(2025,1,19,18,0), u6);
        Item i10 = new Item("Zara Floral Dress",     "Size M summer collection",              fashions,      500000,   700000, "New",         LocalDateTime.of(2025,1,10,10,0),LocalDateTime.of(2025,1,20,20,0), u7);

        // active items
        Item i11 = new Item("iPhone 15 Pro Max",     "256GB Black Titanium 99% new",         mobilePhones,27000000, 29000000, "Used",        LocalDateTime.of(2025,6,1,9,0),  LocalDateTime.of(2027,1,10,18,0), u2);
        Item i12 = new Item("ASUS ROG Laptop",       "RTX 4070 32GB RAM 1TB",                computers,   35000000, 38000000, "Used",        LocalDateTime.of(2025,6,5,9,0),  LocalDateTime.of(2027,1,15,20,0), u6);
        Item i13 = new Item("Sony WH-1000XM5",      "Noise cancelling headphones",           electronics,  6000000,  7000000, "New",         LocalDateTime.of(2025,7,1,9,0),  LocalDateTime.of(2027,2,1,18,0),  u2);
        Item i14 = new Item("Kitchen Knife Set",     "Professional 8-piece chef set",         kitchenTools, 2000000,  2500000, "New",         LocalDateTime.of(2025,7,10,10,0),LocalDateTime.of(2027,2,10,18,0), u4);
        Item i15 = new Item("DJI Mini 4 Pro",        "34 min flight 4K camera",              technologies,18000000, 20000000, "Used",        LocalDateTime.of(2025,8,1,9,0),  LocalDateTime.of(2027,4,10,18,0), u8);
        Item i16 = new Item("Levi 501 Jeans",        "Size 32 classic straight fit",         fashions,      600000,   800000, "Used",        LocalDateTime.of(2025,8,5,9,0),  LocalDateTime.of(2027,3,1,18,0),  u5);
        Item i17 = new Item("Canon EOS R50",         "Body only low shutter count",          technologies,14000000, 16000000, "Used",        LocalDateTime.of(2025,8,10,9,0), LocalDateTime.of(2027,3,15,18,0), u1);
        Item i18 = new Item("RTX 3060 GPU",          "12GB GDDR6 under warranty",            technologies, 7000000,  8000000, "Used",        LocalDateTime.of(2025,9,1,9,0),  LocalDateTime.of(2027,4,1,18,0),  u4);
        Item i19 = new Item("Nike Air Force 1",      "Size 42 white classic",                shoes,         500000,   700000, "Used",        LocalDateTime.of(2025,9,5,9,0),  LocalDateTime.of(2027,4,5,18,0),  u3);
        Item i20 = new Item("Cooking Book Set",      "Gordon Ramsay 3-book collection",      foodsKitchen,  800000,  1000000, "New",         LocalDateTime.of(2025,9,10,9,0), LocalDateTime.of(2027,4,20,18,0), u7);

        for (Item item : new Item[]{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20}) {
            itemRepo.add(item);
        }

        // SOLD auctions
        makeSoldAuction(auctionRepo, i1,  u2, 29000000, LocalDateTime.of(2025,1,1,9,0),  LocalDateTime.of(2025,1,10,18,0));
        makeSoldAuction(auctionRepo, i2,  u5, 480000,   LocalDateTime.of(2025,1,2,10,0), LocalDateTime.of(2025,1,12,20,0));
        makeSoldAuction(auctionRepo, i3,  u4, 1400000,  LocalDateTime.of(2025,1,3,8,0),  LocalDateTime.of(2025,1,13,18,0));
        makeSoldAuction(auctionRepo, i4,  u6, 12500000, LocalDateTime.of(2025,1,4,11,0), LocalDateTime.of(2025,1,14,17,0));
        makeSoldAuction(auctionRepo, i5,  u7, 550000,   LocalDateTime.of(2025,1,5,9,0),  LocalDateTime.of(2025,1,15,21,0));
        makeSoldAuction(auctionRepo, i6,  u8, 950000,   LocalDateTime.of(2025,1,6,10,0), LocalDateTime.of(2025,1,16,19,0));
        makeSoldAuction(auctionRepo, i8,  u5, 16000000, LocalDateTime.of(2025,1,8,12,0), LocalDateTime.of(2025,1,18,20,0));
        makeSoldAuction(auctionRepo, i10, u3, 650000,   LocalDateTime.of(2025,1,10,10,0),LocalDateTime.of(2025,1,20,20,0));

        // UNSOLD auctions
        makeUnsoldAuction(auctionRepo, i7,  LocalDateTime.of(2025,1,7,8,0),  LocalDateTime.of(2025,1,17,18,0));
        makeUnsoldAuction(auctionRepo, i9,  LocalDateTime.of(2025,1,9,9,0),  LocalDateTime.of(2025,1,19,18,0));

        // ACTIVE auctions
        auctionRepo.add(new Auction(i11, LocalDateTime.of(2025,6,1,9,0),   LocalDateTime.of(2027,1,10,18,0)));
        auctionRepo.add(new Auction(i12, LocalDateTime.of(2025,6,5,9,0),   LocalDateTime.of(2027,1,15,20,0)));
        auctionRepo.add(new Auction(i13, LocalDateTime.of(2025,7,1,9,0),   LocalDateTime.of(2027,2,1,18,0)));
        auctionRepo.add(new Auction(i14, LocalDateTime.of(2025,7,10,10,0), LocalDateTime.of(2027,2,10,18,0)));
        auctionRepo.add(new Auction(i15, LocalDateTime.of(2025,8,1,9,0),   LocalDateTime.of(2027,4,10,18,0)));
        auctionRepo.add(new Auction(i16, LocalDateTime.of(2025,8,5,9,0),   LocalDateTime.of(2027,3,1,18,0)));
        auctionRepo.add(new Auction(i17, LocalDateTime.of(2025,8,10,9,0),  LocalDateTime.of(2027,3,15,18,0)));
        auctionRepo.add(new Auction(i18, LocalDateTime.of(2025,9,1,9,0),   LocalDateTime.of(2027,4,1,18,0)));
        auctionRepo.add(new Auction(i19, LocalDateTime.of(2025,9,5,9,0),   LocalDateTime.of(2027,4,5,18,0)));
        auctionRepo.add(new Auction(i20, LocalDateTime.of(2025,9,10,9,0),  LocalDateTime.of(2027,4,20,18,0)));
    }

    private static void makeSoldAuction(AuctionRepository repo, Item item, User winner,
                                        double finalPrice, LocalDateTime start, LocalDateTime end) {
        Auction auction = new Auction(item, start, end);
        auction.setStatus(Auction.SOLD);
        auction.setFinalSalePrice(finalPrice);
        auction.setCurrentHighestBid(finalPrice);
        auction.setWinner(winner);
        repo.add(auction);

        PaymentRepository payRepo = new PaymentRepository();
        double commRate = item.getCategory().getCommissionRate();
        Payment payment = new Payment(auction, winner, item.getSeller(), finalPrice, commRate);
        payment.setStatus(Payment.COMPLETED);
        payRepo.add(payment);
    }

    private static void makeUnsoldAuction(AuctionRepository repo, Item item,
                                          LocalDateTime start, LocalDateTime end) {
        Auction auction = new Auction(item, start, end);
        auction.setStatus(Auction.UNSOLD);
        repo.add(auction);
    }
}
