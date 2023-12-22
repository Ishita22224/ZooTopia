# ZooBuddies - Your Ultimate Zoo Management Application

Welcome to ZooBuddies, a revolutionary zoo management application that allows you to explore and experience the wonders of the animal kingdom.

## Application Flow

The application will have a user-friendly command-line interface where you can enter as either an admin or a visitor.

**Admins** can manage the zoo's attractions, animals, and visitor information. They can also add special events and discounts.
**Visitors** can enjoy different levels of zoo experiences: "Basic," "Premium,". These levels offer varying perks and access to different areas of the zoo.


## Assumptions
1. The ZOOtopia has already been initialised with 3-Attractions (Jungle Safari, Botanical Garden, Dinosaur Show), 6-Animals(Lion, Elephant, Snake, Lizard, Red Eyed Tree Frog, Wood Frog), 2-Discounts(MINOR10, SENIOR20) and 2-Special Deals same as in the Assignment.
### Assumptions for Admin Functionalities
1. Username for Admin : Ishita, Password for Admin : 1234@ishita
2. To refer to Discounts, you need to enter the discount's Serial Number.
3. To refer to Special Deals , you need to enter the Special Deal's Serial Number.
4. Administrators have the option to create new special deals and discounts, not limited to the two specified in the assignment. These other discounts will be applied without checks based on their category. However, for special deals, there will be a verification to ensure that the minimum number of tickets required is met.
### Assumptions for Visitor Functionalities
1. Visitor Register:
   (i) Name cannot contain digits or special characters.

   (ii) Phone Number should be a 10-digit number.

   (iii) Email address must include the '@' symbol.

2. Buying Membership: When "none" entered as discount code, the membership is purchased without applying any discount. When Invalid Discount Code entered, membership is not purchased.
3. When purchasing n-tickets, visitors have n-attempts to enter the attraction ID and a valid discount code; if either is invalid, it is disregarded, and only the correctly entered ones are considered purchased with special deals applied accordingly.
4. Whenever you have to choose an animal, and it says "Enter Animal No.: ", you have to enter the corresponding serial No.
5. To validate a discount code, it must be entered exactly as it is, including the case.
### Assumption for Attraction
1. Attractions are open when the status is set to 1 and closed when the status is set to 0. And any value entered instead of 0 or 1 while modifying or scheduling attractions is an invalid value.
2. Tickets Prices less than or equal to zero will not be considered valid prices.
### Assumption for Animal 
1. If an animal of the same kind is added, the count of that kind of animal is increased.
2. Each animal has a predefined description based on its type, and the admin can edit or add more details to the animal's description or history.
### Assumption for Discount
1. Discount Percentage less than or equal to zero will not be considered valid discounts.
### Assumption for Special Deals
1. Special Deals Discount Percentage and minimum number of tickets required being less than or equal to zero will not be considered valid discounts.

## Main Class

The `Main` class serves as the entry point for the ZOOtopia application. It handles user interactions, including administration and visitor functionalities. The class initializes the zoo with attractions, animals, discounts, and special deals.

### Key Functions
1. **INITIALISES ZOOTOPIA**: Initializes Zootopia with 3-Attractions, 6-Animals, 2-Discounts and 2-Special Deals.
2. **ENTER AS ADMIN OR VISITOR**: Handles admin login, visitor registration, and visitor login.


3. **ADMIN FUNCTIONS**: Handles the flow of admin working with zootopia. Provides a user-friendly command line interface to do operations including the below options --

  
  - **Manage Attractions** - gives an option to add, remove or modify existing Attractions.

  - **Manage Animals** - gives an option to add, remove or modify details of existing Animals.

  - **Schedule Events** - allows to schedule Attractions: open/close, set ticket prices.

  - **Set Discounts** - gives an option to add, remove or modify details of existing Discounts.

  - **Set Special Deal** - gives an option to add, remove or modify details of existing Special Deals.

  - **View Visitor Stats** - tells about the number of visitors, revenue generated and the most visited attraction.

  - **View Feedback** - lists all the feedbacks by the visitors.



4. **VISITOR FUNCTIONS**: Enables visitors to explore all available options and enjoy their time in Zootopia. Provides a user-friendly command line interface to do operations including the below options --

  
  - **Explore the Zoo** - Enables visitors to view Attractions and Animals in the zoo.

  - **Buy MemberShip** - Enables the visitors to buy basic or premium membership.

  - **Buy Tickets** - Enables visitors to purchase tickets, apply discount codes, and automatically utilize available special deals at Zootopia.

  - **View Discounts** - Enables visitors to view the discounts available.

  - **View Special Deals** - Enables visitors to view the special deals available.

  - **Visit Animals** - Gives an option to visitors to feed or read about the animal.

  - **Visit Attractions** - Enables visitors to visit attractions

  - **Leave Feedback** - Enables visitors to leave a feedback for ZOOtopia.


## Admin Class

The `Admin` class is primarily responsible for handling administrative operations within the ZOOtopia application. It provides functionalities for managing attractions, animals, discounts, special deals, and viewing visitor statistics and feedback.

### Key Functions

1. **MANAGE ATTRACTIONS**:
   - Add Attraction
   - Modify Attraction
   - Remove Attraction
   
2. **MANAGE ANIMALS**:
   - Add Animal
   - Update Animal Detail
   - Remove Animal
3. **SCHEDULE EVENTS**: Admin can schedule events and change their status (open or closed).
4. **MANAGE DISCOUNTS**:
   - Add Discount
   - Modify Discount
   - Remove Discount
5.**MANAGE SPECIAL DEALS**:
   - Add Special Deal
   - Modify Special Deal
   - Remove Special Deal
6. **View Visitor Statistics**: Provides statistics on the total number of visitors and the zoo's total revenue.
7. **View Feedback**: Allows administrators to view visitor feedback.


# Visitor Class

The Visitor class is an essential component of the ZooTopia application, responsible for modeling and managing the behavior of visitors to the zoo. Visitors can explore the zoo, buy memberships, purchase tickets, interact with animals, view attractions, leave feedback, and access various features of the application.

### Properties
- `name`: The visitor's name.
- `age`: The age of the visitor.
- `phone`: The visitor's contact phone number.
- `balance`: The balance in the visitor's account.
- `email`: The visitor's email address.
- `password`: The password associated with the visitor's account.
- `feedback`: Visitor's feedback (optional).
- `membership`: The visitor's membership type (Basic or Premium).
- `listTicketBought`: A list of attractions for which the visitor has purchased tickets.
- `listAttractionVisited`: A list of attractions visited by the visitor.
- `listAnimalVisited`: A list of animals interacted with by the visitor.


### Important Methods

1. **exploreTheZoo**: Provides an option for the visitor to view attractions or view animals.
2. **buyMemberShip**: Enables visitors to purchase memberships(Basic or Premium), with or without a discount code. It updates the visitor's balance accordingly.
3. **buyTickets**: Enables visitors to buy tickets. For premium members, no ticket purchase is required. For basic members, it prompts them to specify the number of tickets, then processes ticket purchases with or without discounts, as specified by the visitor.
4. **visitAnimals**: Allows visitors to view and interact with animals in the zoo. They can choose to feed the animals or read about them.
5. **visitAttraction**: Allows visitors to visit zoo attractions based on their membership type (Premium or Basic) and ticket ownership. The method also checks the attraction's availability and opening status.
6. **setFeedback**: Allows visitors to give feedback about their zoo experience.
7. **viewDiscounts** and **viewSpecialDeals**: Enables visitors to view available discounts and special deals, which can be useful when purchasing tickets or memberships.

## User Interface

The User interface outlines fundamental functionalities shared by both visitors and admins. Nevertheless, the specific implementations differ between the two, with admins enjoying access to more detailed information about attractions, animals, deals, and discounts.

### Methods
- viewAttractions
- viewAnimals
- viewDiscounts
- viewSpecialDeals


## Attraction Class

### Properties
- `name`: The name of the attraction.
- `description`: A brief description of the attraction.
- `ticketPrice`: The price of the attraction's ticket.
- `ID`: A unique identifier for the attraction.
- `numVisitors`: The number of visitors who have visited the attraction.
 `status`: The status of the attraction (e.g., open or closed).

### Methods
1. **getWelcomeMsg()**: Generates a welcoming message for visitors as they enter the attraction.
2. **getThankyouMsg()**: Generates a thankyou message for the visitors as they visit the attraction.

## Animal Class

The Animal class represents various animals in the zoo. It is an abstract class, which means that specific animal types should implement their noise-making behavior.

### Attributes
- `name`: Represents the name of the animal.
- `type`: Describes the type or species of the animal.
- `noise`: Contains the typical noise or sound the animal makes.
- `briefPas`: Provides a brief passage or description of the animal.
- `count`: Keeps track of how many times the animal is encountered.

### Note: 
Three classes - Mammal, Amphibian and Reptile inherit this class and implement makeNoise() and getBriefPassage().

## Deal Class

The Deal class represents different discounts available in the zoo. These deals can be applied when purchasing tickets or memberships, providing cost savings to visitors.

### Attributes
- `codeName`: A unique code generated based on the category and percentage, used to identify the deal.
- `category`: Describes the category of the deal (e.g., "student," "senior," "family").
- `percentage`: Indicates the discount percentage offered by the deal.

### Methods
1. **setCodeName**: This method sets the name of the discount coupon.
2. **getMsg**: Returns one line explanation of discount along with its name and percentage.


## SpecialDeal Class

The SpecialDeal class represents special deals available in the zoo. These special deals are automatically applied when purchasing tickets providing cost savings to visitors.

### Attributes
- `numTickets`: Minimum number of tickets required to be bought by the visitor for application of the special deal
- `msg`: Contains a statement describing the special deal.
- `percentage`: Indicates the discount percentage offered by the deal.

