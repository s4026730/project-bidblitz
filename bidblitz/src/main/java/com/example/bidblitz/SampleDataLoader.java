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
        repo.add(new Category("Electronics",      "Phones, laptops and tablets",          4.5));
        repo.add(new Category("Fashion",           "Clothing, shoes and accessories",      5.0));
        repo.add(new Category("Home and Kitchen",  "Furniture and household items",        3.5));
        repo.add(new Category("Sports",            "Sporting goods and fitness",           4.0));
        repo.add(new Category("Books",             "Textbooks and literature",             3.0));
        repo.add(new Category("Collectibles",      "Antiques, coins and stamps",           6.0));
        repo.add(new Category("Vehicles",          "Motorbikes, cars and parts",           2.5));
        repo.add(new Category("Art",               "Paintings and sculptures",             7.0));
        repo.add(new Category("Toys",              "Kids toys and model kits",             4.5));
        repo.add(new Category("Jewelry",           "Gold, silver and gemstones",           6.5));
    }

    private static void loadUsers() {
        UserRepository repo = new UserRepository();
        repo.add(new User("Nguyen Van An",    LocalDateTime.of(1990,3,15,0,0),  "vanan@gmail.com",    "0901234561", "vanan",    "pass123", User.ROLE_USER,         15000000));
        repo.add(new User("Tran Thi Binh",   LocalDateTime.of(1985,7,22,0,0),  "thibinh@gmail.com",  "0901234562", "thibinh",  "pass123", User.ROLE_USER,         8500000));
        repo.add(new User("Le Hoang Nam",    LocalDateTime.of(1992,11,8,0,0),  "hoangnam@gmail.com", "0901234563", "hoangnam", "pass123", User.ROLE_USER,         22000000));
        repo.add(new User("Pham Thi Lan",    LocalDateTime.of(1988,4,30,0,0),  "thilan@gmail.com",   "0901234564", "thilan",   "pass123", User.ROLE_USER,         3200000));
        repo.add(new User("Hoang Van Duc",   LocalDateTime.of(1995,9,14,0,0),  "vanduc@gmail.com",   "0901234565", "vanduc",   "pass123", User.ROLE_USER,         50000000));
        repo.add(new User("Vo Thi Mai",      LocalDateTime.of(1983,12,1,0,0),  "thimai@gmail.com",   "0901234566", "thimai",   "pass123", User.ROLE_USER,         11000000));
        repo.add(new User("Dang Minh Tuan",  LocalDateTime.of(1997,6,25,0,0),  "minhtuan@gmail.com", "0901234567", "minhtuan", "pass123", User.ROLE_USER,         7500000));
        repo.add(new User("Bui Thi Thu",     LocalDateTime.of(1980,2,18,0,0),  "thithu@gmail.com",   "0901234568", "thithu",   "pass123", User.ROLE_USER,         33000000));
        repo.add(new User("Do Van Hung",     LocalDateTime.of(1993,8,5,0,0),   "vanhung@gmail.com",  "0901234569", "vanhung",  "pass123", User.ROLE_USER,         6000000));
        repo.add(new User("Nguyen Thi Hoa",  LocalDateTime.of(1991,1,12,0,0),  "thihoa@gmail.com",   "0901234570", "thihoa",   "pass123", User.ROLE_USER,         18000000));
        repo.add(new User("Tran Van Long",   LocalDateTime.of(1987,5,20,0,0),  "vanlong@gmail.com",  "0901234571", "vanlong",  "pass123", User.ROLE_USER,         4200000));
        repo.add(new User("Le Thi Phuong",   LocalDateTime.of(1999,10,3,0,0),  "thiphuong@gmail.com","0901234572", "thiphuong","pass123", User.ROLE_USER,         9000000));
        repo.add(new User("Pham Van Khanh",  LocalDateTime.of(1994,3,28,0,0),  "vankhanh@gmail.com", "0901234573", "vankhanh", "pass123", User.ROLE_USER,         27500000));
        repo.add(new User("Hoang Thi Yen",   LocalDateTime.of(1986,7,9,0,0),   "thiyen@gmail.com",   "0901234574", "thiyen",   "pass123", User.ROLE_USER,         13500000));
        repo.add(new User("Vo Van Thanh",    LocalDateTime.of(1998,12,17,0,0), "vanthanh@gmail.com", "0901234575", "vanthanh", "pass123", User.ROLE_USER,         6800000));
        repo.add(new User("admin",           LocalDateTime.of(1985,1,1,0,0),   "admin@bidblitz.com", "0900000001", "admin",    "admin123",User.ROLE_SYSTEM_ADMIN,  0));
        repo.add(new User("auctionadmin",    LocalDateTime.of(1990,1,1,0,0),   "aadmin@bidblitz.com","0900000002", "aadmin",   "admin123",User.ROLE_AUCTION_ADMIN, 0));
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

        Category electronics  = cats.get(0);
        Category fashion      = cats.get(1);
        Category home         = cats.get(2);
        Category sports       = cats.get(3);
        Category books        = cats.get(4);
        Category collectibles = cats.get(5);
        Category vehicles     = cats.get(6);
        Category art          = cats.get(7);
        Category toys         = cats.get(8);
        Category jewelry      = cats.get(9);

        // past SOLD items
        Item i1 = new Item("MacBook Pro M3",         "M3 chip 16GB RAM 512GB SSD",       electronics,  28000000, 30000000, "Used",   LocalDateTime.of(2025,1,1,9,0),  LocalDateTime.of(2025,1,10,18,0), u1);
        Item i2 = new Item("Denim Jacket",           "Size L, dark blue",                fashion,       350000,    500000, "Used",   LocalDateTime.of(2025,1,2,10,0), LocalDateTime.of(2025,1,12,20,0), u3);
        Item i3 = new Item("Philips Blender",        "1200W, 12 month warranty",          home,         1200000,  1500000, "New",    LocalDateTime.of(2025,1,3,8,0),  LocalDateTime.of(2025,1,13,18,0), u5);
        Item i4 = new Item("Giant Road Bike",        "Aluminum frame, 21 speed",          sports,       4500000,  5000000, "Used",   LocalDateTime.of(2025,1,4,11,0), LocalDateTime.of(2025,1,14,17,0), u8);
        Item i5 = new Item("Doraemon Manga Set",     "45 volumes, original edition",      books,         800000,  1000000, "Used",   LocalDateTime.of(2025,1,5,9,0),  LocalDateTime.of(2025,1,15,21,0), u2);
        Item i6 = new Item("1945 Vietnam Coin",      "Rare antique, good condition",      collectibles, 1200000,  1500000, "Used",   LocalDateTime.of(2025,1,6,10,0), LocalDateTime.of(2025,1,16,19,0), u7);
        Item i7 = new Item("Honda Air Blade 2022",   "12000km, HN plate",                 vehicles,    38000000, 42000000, "Used",   LocalDateTime.of(2025,1,7,8,0),  LocalDateTime.of(2025,1,17,18,0), u4);
        Item i8 = new Item("Oil Painting Landscape", "60x80cm, signed original",          art,          3500000,  4000000, "New",    LocalDateTime.of(2025,1,8,12,0), LocalDateTime.of(2025,1,18,20,0), u3);
        Item i9 = new Item("LEGO Star Wars 75257",   "Complete set with box",             toys,         2800000,  3000000, "Used",   LocalDateTime.of(2025,1,9,9,0),  LocalDateTime.of(2025,1,19,18,0), u6);
        Item i10 = new Item("Diamond Ring 0.5ct",    "18k white gold, GIA certified",     jewelry,     22000000, 25000000, "New",    LocalDateTime.of(2025,1,10,10,0),LocalDateTime.of(2025,1,20,20,0), u7);

        // active items
        Item i11 = new Item("iPhone 15 Pro Max",     "256GB, Black Titanium",             electronics, 27000000, 29000000, "Used",   LocalDateTime.of(2025,6,1,9,0),  LocalDateTime.of(2027,1,10,18,0), u2);
        Item i12 = new Item("PlayStation 5 Slim",    "Disc edition, 2 controllers",       toys,        11000000, 12000000, "Used",   LocalDateTime.of(2025,6,5,9,0),  LocalDateTime.of(2027,1,15,20,0), u6);
        Item i13 = new Item("Rolex Datejust",        "2021, full box and papers",         jewelry,    150000000,180000000, "Used",   LocalDateTime.of(2025,7,1,9,0),  LocalDateTime.of(2027,2,1,18,0),  u2);
        Item i14 = new Item("Leather Sofa Set",      "3-piece, genuine leather",          home,        15000000, 18000000, "Refurbished",LocalDateTime.of(2025,7,10,10,0),LocalDateTime.of(2027,2,10,18,0), u4);
        Item i15 = new Item("DJI Mini 4 Pro",        "34 min flight, 4K camera",          electronics, 18000000, 20000000, "Used",   LocalDateTime.of(2025,8,1,9,0),  LocalDateTime.of(2027,4,10,18,0), u8);
        Item i16 = new Item("Yamaha F310 Guitar",    "Acoustic, barely used",             art,          1800000,  2000000, "Used",   LocalDateTime.of(2025,8,5,9,0),  LocalDateTime.of(2027,3,1,18,0),  u5);
        Item i17 = new Item("Canon EOS R50",         "Body only, low shutter count",      electronics, 14000000, 16000000, "Used",   LocalDateTime.of(2025,8,10,9,0), LocalDateTime.of(2027,3,15,18,0), u1);
        Item i18 = new Item("RTX 3060 GPU",          "12GB GDDR6, under warranty",        electronics,  7000000,  8000000, "Used",   LocalDateTime.of(2025,9,1,9,0),  LocalDateTime.of(2027,4,1,18,0),  u4);
        Item i19 = new Item("Vintage Sneakers",      "Nike Air Force 1, size 42",         fashion,       500000,   700000, "Used",   LocalDateTime.of(2025,9,5,9,0),  LocalDateTime.of(2027,4,5,18,0),  u3);
        Item i20 = new Item("Mountain Bike Helmet",  "Full face, size M",                 sports,        800000,  1000000, "New",    LocalDateTime.of(2025,9,10,9,0), LocalDateTime.of(2027,4,20,18,0), u7);

        for (Item item : new Item[]{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20}) {
            itemRepo.add(item);
        }

        // SOLD auctions
        makeSoldAuction(auctionRepo, i1, u2, 29000000, LocalDateTime.of(2025,1,1,9,0),  LocalDateTime.of(2025,1,10,18,0));
        makeSoldAuction(auctionRepo, i2, u5, 480000,   LocalDateTime.of(2025,1,2,10,0), LocalDateTime.of(2025,1,12,20,0));
        makeSoldAuction(auctionRepo, i3, u4, 1400000,  LocalDateTime.of(2025,1,3,8,0),  LocalDateTime.of(2025,1,13,18,0));
        makeSoldAuction(auctionRepo, i4, u6, 4800000,  LocalDateTime.of(2025,1,4,11,0), LocalDateTime.of(2025,1,14,17,0));
        makeSoldAuction(auctionRepo, i5, u7, 950000,   LocalDateTime.of(2025,1,5,9,0),  LocalDateTime.of(2025,1,15,21,0));
        makeSoldAuction(auctionRepo, i6, u8, 1350000,  LocalDateTime.of(2025,1,6,10,0), LocalDateTime.of(2025,1,16,19,0));
        makeSoldAuction(auctionRepo, i8, u5, 3800000,  LocalDateTime.of(2025,1,8,12,0), LocalDateTime.of(2025,1,18,20,0));
        makeSoldAuction(auctionRepo, i10, u3, 23000000, LocalDateTime.of(2025,1,10,10,0),LocalDateTime.of(2025,1,20,20,0));

        // UNSOLD auctions
        makeUnsoldAuction(auctionRepo, i7, LocalDateTime.of(2025,1,7,8,0), LocalDateTime.of(2025,1,17,18,0));
        makeUnsoldAuction(auctionRepo, i9, LocalDateTime.of(2025,1,9,9,0), LocalDateTime.of(2025,1,19,18,0));

        // ACTIVE auctions
        auctionRepo.add(new Auction(i11, LocalDateTime.of(2025,6,1,9,0),  LocalDateTime.of(2027,1,10,18,0)));
        auctionRepo.add(new Auction(i12, LocalDateTime.of(2025,6,5,9,0),  LocalDateTime.of(2027,1,15,20,0)));
        auctionRepo.add(new Auction(i13, LocalDateTime.of(2025,7,1,9,0),  LocalDateTime.of(2027,2,1,18,0)));
        auctionRepo.add(new Auction(i14, LocalDateTime.of(2025,7,10,10,0),LocalDateTime.of(2027,2,10,18,0)));
        auctionRepo.add(new Auction(i15, LocalDateTime.of(2025,8,1,9,0),  LocalDateTime.of(2027,4,10,18,0)));
        auctionRepo.add(new Auction(i16, LocalDateTime.of(2025,8,5,9,0),  LocalDateTime.of(2027,3,1,18,0)));
        auctionRepo.add(new Auction(i17, LocalDateTime.of(2025,8,10,9,0), LocalDateTime.of(2027,3,15,18,0)));
        auctionRepo.add(new Auction(i18, LocalDateTime.of(2025,9,1,9,0),  LocalDateTime.of(2027,4,1,18,0)));
        auctionRepo.add(new Auction(i19, LocalDateTime.of(2025,9,5,9,0),  LocalDateTime.of(2027,4,5,18,0)));
        auctionRepo.add(new Auction(i20, LocalDateTime.of(2025,9,10,9,0), LocalDateTime.of(2027,4,20,18,0)));
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
