package com.example.recipemenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class RecipePagerAdapter extends PagerAdapter {

    private final Context context;
    private final int cuisineIndex;

    private final String[][] recipeNames = {
            {"Pizza Margherita", "Spaghetti Carbonara", "Lasagna", "Risotto",
                    "Ravioli", "Gnocchi", "Tiramisu", "Panna Cotta"},
            {"Paneer Butter Masala", "Biryani", "Chole Bhature", "Masala Dosa",
                    "Pav Bhaji", "Aloo Paratha", "Samosa", "Pani Puri"},
            {"Sweet and Sour", "Fried Rice", "Spring Rolls", "Chow Mein",
                    "Dim Sum", "Hot and Sour Soup", "Szechuan Tofu", "Dumplings"},
            {"Tacos", "Burritos", "Enchiladas", "Quesadillas",
                    "Churros", "Nachos", "Pozole", "Fajitas"},
            {"Sushi", "Ramen", "Tempura", "Sashimi",
                    "Teriyaki Chicken", "Takoyaki", "Okonomiyaki", "Matcha Ice Cream"},
            {"Pad Thai", "Green Curry", "Massaman Curry", "Som Tum (Papaya Salad)",
                    "Panang Curry", "Thai Fried Rice", "Satay", "Red Curry"},
            {"Croissants", "Ratatouille", "Coq au Vin", "Bouillabaisse",
                    "Beef Bourguignon", "Macarons", "Quiche Lorraine", "Madeleines"},
            {"Moussaka", "Tzatziki", "Spanakopita", "Dolma",
                    "Greek Salad", "Baklava", "Gyro", "Fasolada"},
            {"Hummus", "Falafel", "Shawarma", "Tabbouleh",
                    "Pita Bread", "Kofta", "Fattoush", "Lentil Soup",},
            {"Kimchi", "Bibimbap", "Bulgogi", "Japchae",
                    "Korean Fried Chicken", "Samgyeopsal", "Kimchi Jjigae", "Hotteok"},
    };

    private final String[][] recipeingrediant = {
            {"Flour Water" + "\n" + "Yeast" + "\n" + "Mozzarella Cheese" + "\n" + "Tomato Sauce" + "\n" + "Fresh Basil",
                    "Spaghetti" + "\n" + "Eggs" + "\n" + " Parmesan Cheese" + "\n" + "Bacon (or Guanciale)" + "\n" + "Garlic" + "\n" + "Black Pepper",
                    "Lasagna Sheets" + "\n" + " Ground Beef (or Pork)" + "\n" + " Ricotta Cheese" + "\n" + " Tomato Sauce" + "\n" + " Mozzarella Cheese" + "\n" + "Parmesan Cheese" + "\n" + " Garlic" + "\n" + " Onion" + "\n" + " Egg",
                    "Arborio Rice" + "\n" + "Onion" + "\n" + "White Wine" + "\n" + "Chicken Broth (or Vegetable Broth)" + "\n" + "Parmesan Cheese" + "\n" + "Butter" + "\n" + "Olive Oil",
                    "Pasta Dough (Flour, Eggs, Olive Oil)" + "\n" + "Ricotta Cheese" + "\n" + "Spinach" + "\n" + "Parmesan Cheese" + "\n" + "Nutmeg",
                    "Potatoes" + "\n" + "All-Purpose Flour" + "\n" + "Egg" + "\n" + "Parmesan Cheese" + "\n" + "Salt",
                    "Mascarpone Cheese" + "\n" + "Ladyfingers (Savoiardi)" + "\n" + "Coffee (Espresso)" + "\n" + "Cocoa Powder" + "\n" + "Eggs" + "\n" + "Sugar" + "\n" + "Marsala Wine (Optional)",
                    "Heavy Cream" + "\n" + "Sugar" + "\n" + "Gelatin" + "\n" + "Vanilla Extract"},
            {"Paneer" + "\n" + "Butter" + "\n" + "Tomato" + "\n" + "Cream" + "\n" + "Spices",
                    "Basmati Rice" + "\n" + "Chicken (or Mutton)" + "\n" + "Yogurt" + "\n" + "Saffron" + "\n" + "Spices" + "\n" + "Onion" + "\n" + "Garlic",
                    "Chickpeas" + "\n" + "Flour" + "\n" + "Spices" + "\n" + "Oil",
                    "Rice Flour" + "\n" + "Lentils" + "\n" + "Mustard Seeds" + "\n" + "Curry Leaves" + "\n" + "Tamarind",
                    "Pav Bread" + "\n" + "Potatoes" + "\n" + "Tomatoes" + "\n" + "Peas" + "\n" + "Spices" + "\n" + "Butter",
                    "Wheat Flour" + "\n" + "Potatoes" + "\n" + "Ghee" + "\n" + "Spices",
                    "Flour" + "\n" + "Potatoes" + "\n" + "Spices" + "\n" + "Oil",
                    "Pani (Tamarind Water)" + "\n" + "Flour" + "\n" + "Potatoes" + "\n" + "Chickpeas" + "\n" + "Spices"},
            {"Pineapple" + "\n" + "Bell Peppers" + "\n" + "Vinegar" + "\n" + "Soy Sauce" + "\n" + "Sugar" + "\n" + "Ginger" + "\n" + "Garlic",
                    "Rice" + "\n" + "Vegetables" + "\n" + "Soy Sauce" + "\n" + "Eggs" + "\n" + "Oil" + "\n" + "Spring Onion",
                    "Spring Roll Wrappers" + "\n" + "Cabbage" + "\n" + "Carrot" + "\n" + "Noodles" + "\n" + "Soy Sauce" + "\n" + "Oil",
                    "Egg Noodles" + "\n" + "Vegetables" + "\n" + "Soy Sauce" + "\n" + "Ginger" + "\n" + "Garlic" + "\n" + "Spring Onions",
                    "Dumpling Wrappers" + "\n" + "Ground Pork" + "\n" + "Vegetables" + "\n" + "Soy Sauce" + "\n" + "Ginger" + "\n" + "Garlic",
                    "Chili Paste" + "\n" + "Tofu" + "\n" + "Soy Sauce" + "\n" + "Garlic" + "\n" + "Ginger" + "\n" + "Szechuan Peppercorns",
                    "Dumpling Wrappers" + "\n" + "Ground Meat or Vegetables" + "\n" + "Soy Sauce" + "\n" + "Garlic" + "\n" + "Ginger",
                    "Dumpling Wrappers" + "\n" + "Ground Meat" + "\n" + "Garlic" + "\n" + "Soy Sauce" + "\n" + "Ginger" + "\n" + "Spring Onions"},
            {"Corn Tortillas" + "\n" + "Ground Beef" + "\n" + "Chicken" + "\n" + "Pork" + "\n" + "Rice" + "\n" + "Beans" + "\n" + "Cheese" + "\n" + "Salsa" + "\n" + "Lettuce",
                    "Flour Tortillas" + "\n" + "Rice" + "\n" + "Beans" + "\n" + "Avocado" + "\n" + "Cheese" + "\n" + "Chicken" + "\n" + "Beef" + "\n" + "Pork",
                    "Corn Tortillas" + "\n" + "Cheese" + "\n" + "Chicken" + "\n" + "Beef" + "\n" + "Beans" + "\n" + "Spices" + "\n" + "Salsa",
                    "Flour Tortillas" + "\n" + "Cheese" + "\n" + "Chicken" + "\n" + "Beef" + "\n" + "Vegetables" + "\n" + "Salsa",
                    "Flour" + "\n" + "Sugar" + "\n" + "Water" + "\n" + "Oil" + "\n" + "Cinnamon",
                    "Tortilla Chips" + "\n" + "Cheese" + "\n" + "Salsa" + "\n" + "Jalapeños" + "\n" + "Ground Beef",
                    "Pork" + "\n" + "Corn" + "\n" + "Chile" + "\n" + "Lime" + "\n" + "Cabbage" + "\n" + "Radishes",
                    "Flour Tortillas" + "\n" + "Chicken" + "\n" + "Beef" + "\n" + "Spices" + "\n" + "Bell Peppers" + "\n" + "Onions"},
            {"Sushi Rice" + "\n" + "Nori (Seaweed)" + "\n" + "Fish (Salmon, Tuna)" + "\n" + "Wasabi" + "\n" + "Soy Sauce",
                    "Ramen Noodles" + "\n" + "Broth (Pork or Chicken)" + "\n" + "Eggs" + "\n" + "Toppings (Bamboo Shoots, Corn, Green Onions)",
                    "Shrimp" + "\n" + "Vegetables (Zucchini, Bell Peppers)" + "\n" + "Tempura Batter",
                    "Fresh Fish" + "\n" + "Soy Sauce" + "\n" + "Wasabi" + "\n" + "Seaweed",
                    "Chicken" + "\n" + "Soy Sauce" + "\n" + "Mirin" + "\n" + "Rice Wine" + "\n" + "Honey" + "\n" + "Ginger",
                    "Fish" + "\n" + "Octopus" + "\n" + "Flour" + "\n" + "Eggs" + "\n" + "Tempura Batter" + "\n" + "Oil",
                    "Cabbage" + "\n" + "Flour" + "\n" + "Eggs" + "\n" + "Fish" + "\n" + "Soy Sauce" + "\n" + "Vinegar",
                    "Matcha Powder" + "\n" + "Milk" + "\n" + "Sugar" + "\n" + "Ice Cream Base"},
            {"Rice Noodles" + "\n" + "Egg" + "\n" + "Peanuts" + "\n" + "Bean Sprouts" + "\n" + "Lime" + "\n" + "Fish Sauce" + "\n" + "Tofu",
                    "Coconut Milk" + "\n" + "Chicken" + "\n" + "Beef" + "\n" + "Bamboo Shoots" + "\n" + "Thai Herbs" + "\n" + "Spices",
                    "Beef" + "\n" + "Potatoes" + "\n" + "Coconut Milk" + "\n" + "Peanut Butter" + "\n" + "Spices" + "\n" + "Tamarind",
                    "Papaya" + "\n" + "Chilies" + "\n" + "Lime" + "\n" + "Fish Sauce" + "\n" + "Carrots" + "\n" + "Peanuts",
                    "Coconut Milk" + "\n" + "Rice" + "\n" + "Peanuts" + "\n" + "Curry Paste" + "\n" + "Lime",
                    "Rice" + "\n" + "Spices" + "\n" + "Vegetables" + "\n" + "Eggs",
                    "Chicken Skewers" + "\n" + "Peanut Sauce" + "\n" + "Lime",
                    "Beef" + "\n" + "Coconut Milk" + "\n" + "Lemongrass" + "\n" + "Spices"},
            {"Butter" + "\n" + "Flour" + "\n" + "Eggs" + "\n" + "Sugar" + "\n" + "Yeast",
                    "Eggplant" + "\n" + "Zucchini" + "\n" + "Tomatoes" + "\n" + "Onion" + "\n" + "Bell Peppers" + "\n" + "Herbs",
                    "Chicken" + "\n" + "Red Wine" + "\n" + "Mushrooms" + "\n" + "Bacon" + "\n" + "Garlic",
                    "Fish" + "\n" + "Shellfish" + "\n" + "Tomatoes" + "\n" + "Saffron" + "\n" + "Garlic" + "\n" + "Onion",
                    "Beef" + "\n" + "Red Wine" + "\n" + "Garlic" + "\n" + "Onion" + "\n" + "Herbs" + "\n" + "Butter",
                    "Almonds" + "\n" + "Egg Whites" + "\n" + "Sugar",
                    "Eggs" + "\n" + "Butter" + "\n" + "Flour" + "\n" + "Cream" + "\n" + "Cheese",
                    "Flour" + "\n" + "Butter" + "\n" + "Sugar" + "\n" + "Eggs" + "\n" + "Baking Powder"},
            {"Eggplant" + "\n" + "Potatoes" + "\n" + "Ground Beef" + "\n" + "Tomatoes" + "\n" + "Spices",
                    "Yogurt" + "\n" + "Cucumber" + "\n" + "Garlic" + "\n" + "Olive Oil" + "\n" + "Lemon",
                    "Spinach" + "\n" + "Feta Cheese" + "\n" + "Phyllo Dough" + "\n" + "Olive Oil",
                    "Rice" + "\n" + "Ground Meat" + "\n" + "Spices" + "\n" + "Vine Leaves",
                    "Cucumber" + "\n" + "Tomatoes" + "\n" + "Feta Cheese" + "\n" + "Olives" + "\n" + "Onion" + "\n" + "Olive Oil",
                    "Phyllo Dough" + "\n" + "Walnuts" + "\n" + "Honey" + "\n" + "Cinnamon",
                    "Lamb" + "\n" + "Pita Bread" + "\n" + "Tomatoes" + "\n" + "Cucumber" + "\n" + "Onion" + "\n" + "Tzatziki",
                    "Olives" + "\n" + "Tomatoes" + "\n" + "Cucumbers" + "\n" + "Feta" + "\n" + "Lemon"
            },
            {"Chickpeas" + "\n" + "Tahini" + "\n" + "Lemon" + "\n" + "Olive Oil" + "\n" + "Garlic",
                    "Chickpeas" + "\n" + "Parsley" + "\n" + "Garlic" + "\n" + "Lemon" + "\n" + "Spices",
                    "Chicken" + "\n" + "Spices" + "\n" + "Garlic" + "\n" + "Yogurt" + "\n" + "Vegetables",
                    "Parsley" + "\n" + "Tomatoes" + "\n" + "Onions" + "\n" + "Lemon" + "\n" + "Olive Oil",
                    "Pita Bread" + "\n" + "Flour" + "\n" + "Water" + "\n" + "Yeast",
                    "Ground Lamb" + "\n" + "Spices" + "\n" + "Herbs",
                    "Tomatoes" + "\n" + "Cucumbers" + "\n" + "Lemon" + "\n" + "Mint" + "\n" + "Olive Oil",
                    "Lentils" + "\n" + "Tomatoes" + "\n" + "Onions" + "\n" + "Spices"
            },
            {"Cabbage" + "\n" + "Chili Paste" + "\n" + "Garlic" + "\n" + "Ginger",
                    "Rice" + "\n" + "Vegetables" + "\n" + "Egg" + "\n" + "Soy Sauce" + "\n" + "Sesame Oil",
                    "Beef" + "\n" + "Pork" + "\n" + "or Chicken" + "\n" + "Rice" + "\n" + "Soy Sauce" + "\n" + "Garlic",
                    "Noodles" + "\n" + "Vegetables" + "\n" + "Soy Sauce" + "\n" + "Sesame Oil",
                    "Flour" + "\n" + "Chicken" + "\n" + "Cornstarch" + "\n" + "Soy Sauce" + "\n" + "Garlic",
                    "Pork" + "\n" + "Vegetables" + "\n" + "Soy Sauce" + "\n" + "Sesame Oil",
                    "Kimchi" + "\n" + "Tofu" + "\n" + "Pork" + "\n" + "Chili Paste",
                    "Flour" + "\n" + "Sugar" + "\n" + "Cinnamon" + "\n" + "Corn Syrup"
            },
    };

    private final String[][] recipeinstruction = {
            {"1. Preheat the oven to 475°F (245°C). Place pizza dough on a baking sheet. " + "\n" +
                    "2. Spread a thin layer of tomato sauce on the dough, then add mozzarella cheese and basil leaves. " + "\n" +
                    "3. Drizzle with olive oil. " + "\n" +
                    "4. Bake for 10-12 minutes or until the crust is golden brown.",

                    "1. Cook the spaghetti in salted boiling water until al dente. " + "\n" +
                            "2. In a pan, cook pancetta until crispy, then add beaten eggs and grated Parmesan. " + "\n" +
                            "3. Toss the pasta with the pancetta mixture. " + "\n" +
                            "4. Add black pepper and serve.",

                    "1. Preheat the oven to 375°F (190°C). " + "\n" +
                            "2. Layer lasagna sheets, ground beef, tomato sauce, mozzarella, and Parmesan. " + "\n" +
                            "3. Repeat layers, then top with bechamel sauce. " + "\n" +
                            "4. Bake for 30-40 minutes or until golden and bubbly.",

                    "1. Heat olive oil and sauté garlic and onion. " + "\n" +
                            "2. Add rice and cook for 1-2 minutes. " + "\n" +
                            "3. Gradually add broth, stirring until rice absorbs the liquid. " + "\n" +
                            "4. Stir in butter, Parmesan, and season to taste.",

                    "1. Roll out ravioli dough and cut into squares. " + "\n" +
                            "2. Place a small amount of ricotta and spinach filling in the center. " + "\n" +
                            "3. Fold and seal the edges. " + "\n" +
                            "4. Boil ravioli until they float to the surface, then serve with sauce.",

                    "1. Boil potatoes until tender, then mash them with flour and eggs. " + "\n" +
                            "2. Shape the dough into small round balls. " + "\n" +
                            "3. Boil the gnocchi until they float to the surface. " + "\n" +
                            "4. Serve with sauce or in broth.",

                    "1. Dip ladyfingers in coffee and layer them in a dish. " + "\n" +
                            "2. Whisk together mascarpone, eggs, sugar, and cocoa powder. " + "\n" +
                            "3. Layer mascarpone mixture over the ladyfingers. " + "\n" +
                            "4. Chill in the fridge for at least 4 hours before serving.",

                    "1. Heat water and dissolve gelatin. " + "\n" +
                            "2. Mix heavy cream, sugar, and vanilla, then combine with gelatin. " + "\n" +
                            "3. Pour the mixture into molds and chill for several hours. " + "\n" +
                            "4. Serve with fruit or syrup."},

            {"1. Heat butter and cream in a pan, add cubed paneer and cook until soft. " + "\n" +
                    "2. Add onion, tomatoes, and spices. " + "\n" +
                    "3. Simmer for 15-20 minutes. " + "\n" +
                    "4. Serve with naan or rice.",

                    "1. Fry onions, tomatoes, and spices in oil. " + "\n" +
                            "2. Add marinated chicken and cook until tender. " + "\n" +
                            "3. Add rice and yogurt, then cook with spices and water. " + "\n" +
                            "4. Garnish with cilantro and serve.",

                    "1. Soak chickpeas overnight, then cook in a pressure cooker. " + "\n" +
                            "2. Heat oil and fry onions, tomatoes, and spices. " + "\n" +
                            "3. Add cooked chickpeas and simmer for 20 minutes. " + "\n" +
                            "4. Serve with rice or naan.",

                    "1. Prepare dosa batter and spread it on a hot griddle. " + "\n" +
                            "2. Fill with spiced potatoes and fold the dosa. " + "\n" +
                            "3. Cook until crispy. " + "\n" +
                            "4. Serve with chutneys and sambar.",

                    "1. Heat oil and cook vegetables in butter. " + "\n" +
                            "2. Add pav bhaji masala and mash the mixture. " + "\n" +
                            "3. Toast pav (bread rolls) in butter and serve with the curry mixture.",

                    "1. Knead wheat flour dough and roll out small circles. " + "\n" +
                            "2. Fill with mashed potatoes, spices, and ghee. " + "\n" +
                            "3. Cook on a griddle until golden brown. " + "\n" +
                            "4. Serve with yogurt and chutney.",

                    "1. Make dough and stuff with spiced potatoes or meat. " + "\n" +
                            "2. Heat oil and fry until golden. " + "\n" +
                            "3. Serve with tamarind chutney.",

                    "1. Fill puris with tamarind water, chickpeas, and spiced water. " + "\n" +
                            "2. Serve immediately for a crispy and refreshing snack."},

            {"1. Heat oil in a pan, add ginger and garlic, sauté until fragrant. " + "\n" +
                    "2. Add bell peppers and pineapple, stir-fry for 2-3 minutes. " + "\n" +
                    "3. Mix in soy sauce, sugar, and vinegar, then simmer until the sauce thickens. " + "\n" +
                    "4. Serve hot with rice.",

                    "1. Cook rice and let it cool. " + "\n" +
                            "2. Heat oil in a wok, add chopped vegetables and sauté for a few minutes. " + "\n" +
                            "3. Push veggies to the side and scramble eggs in the same pan. " + "\n" +
                            "4. Add cooled rice, soy sauce, and stir well. " + "\n" +
                            "5. Garnish with spring onions and serve hot.",

                    "1. Soak the spring roll wrappers in warm water until soft. " + "\n" +
                            "2. Mix shredded cabbage, carrots, and other vegetables. " + "\n" +
                            "3. Place the filling on the wrapper, fold and roll tightly. " + "\n" +
                            "4. Fry the rolls in hot oil until golden brown and crispy. " + "\n" +
                            "5. Serve with dipping sauce.",

                    "1. Cook noodles according to package instructions, drain and set aside. " + "\n" +
                            "2. Heat oil in a wok, sauté ginger, garlic, and vegetables. " + "\n" +
                            "3. Add cooked noodles and soy sauce, stir-fry for 5-7 minutes. " + "\n" +
                            "4. Garnish with spring onions and serve hot.",

                    "1. Prepare the filling (ground pork, vegetables, or shrimp) by mixing all ingredients. " + "\n" +
                            "2. Place a spoonful of filling onto the dumpling wrapper. " + "\n" +
                            "3. Seal the wrapper tightly, folding to create pleats. " + "\n" +
                            "4. Steam the dim sum for 10-15 minutes until cooked through.",

                    "1. In a pot, combine broth, soy sauce, vinegar, and chili paste. " + "\n" +
                            "2. Add sliced mushrooms, tofu, and bamboo shoots. " + "\n" +
                            "3. Bring the mixture to a boil and simmer for 10 minutes. " + "\n" +
                            "4. Add cornstarch slurry to thicken, then adjust seasoning to taste. " + "\n" +
                            "5. Garnish with cilantro and serve hot.",

                    "1. Heat oil in a pan, add ginger, garlic, and Szechuan peppercorns, sauté for 1-2 minutes. " + "\n" +
                            "2. Add tofu cubes and fry until golden brown. " + "\n" +
                            "3. Add soy sauce, chili paste, and Szechuan pepper, stir-fry for another 2 minutes. " + "\n" +
                            "4. Garnish with green onions and serve hot.",

                    "1. Mix ground meat or vegetables with soy sauce, garlic, ginger, and seasoning. " + "\n" +
                            "2. Place a small amount of filling onto each dumpling wrapper and fold to seal. " + "\n" +
                            "3. Steam or boil the dumplings for 10-12 minutes or until cooked through. " + "\n" +
                            "4. Serve with dipping sauce."},

            {"1. Brown ground beef in a skillet and add taco seasoning. " + "\n" +
                    "2. Warm taco shells and fill with beef, lettuce, cheese, salsa, and any toppings of your choice. " + "\n" +
                    "3. Serve immediately with lime wedges.",

                    "1. Cook rice and prepare beans. " + "\n" +
                            "2. Warm large tortillas and layer with rice, beans, cooked meat (chicken, beef, etc.), cheese, and salsa. " + "\n" +
                            "3. Roll up the tortilla and serve with guacamole and sour cream.",

                    "1. Preheat the oven to 375°F (190°C). " + "\n" +
                            "2. Soften corn tortillas and layer them with enchilada sauce, cheese, and cooked chicken or beef. " + "\n" +
                            "3. Roll up the tortillas and bake for 20-25 minutes. " + "\n" +
                            "4. Top with sour cream and salsa before serving.",

                    "1. Heat oil in a skillet. " + "\n" +
                            "2. Fill flour tortillas with cheese, meat, and vegetables. " + "\n" +
                            "3. Cook the quesadillas in the skillet until golden and crispy, flipping as needed. " + "\n" +
                            "4. Serve with guacamole, salsa, or sour cream.",

                    "1. Prepare dough by mixing flour, sugar, salt, and baking powder. " + "\n" +
                            "2. Roll dough into small strips and twist them into churro shapes. " + "\n" +
                            "3. Fry in hot oil until golden brown. " + "\n" +
                            "4. Toss the churros in a cinnamon-sugar mixture and serve with chocolate sauce.",

                    "1. Preheat oven to 375°F (190°C). " + "\n" +
                            "2. Spread tortilla chips on a baking sheet, then top with shredded cheese, jalapenos, and beans. " + "\n" +
                            "3. Bake for 5-10 minutes or until cheese is melted. " + "\n" +
                            "4. Serve with sour cream, salsa, and guacamole.",

                    "1. Heat a pot and sauté onions and garlic. " + "\n" +
                            "2. Add pork or chicken, hominy, and spices. " + "\n" +
                            "3. Simmer for 2-3 hours until tender. " + "\n" +
                            "4. Serve with garnishes like radishes, lime, and cabbage.",

                    "1. Heat oil in a skillet and sauté sliced bell peppers and onions. " + "\n" +
                            "2. Add seasoned beef or chicken and cook until browned. " + "\n" +
                            "3. Serve the fajitas in tortillas with toppings like guacamole, salsa, and sour cream."},

            {"1. Cook sushi rice and season with rice vinegar, sugar, and salt. " + "\n" +
                    "2. Slice fresh fish like tuna or salmon into thin pieces. " + "\n" +
                    "3. Prepare nori (seaweed) sheets and place sushi rice on them. " + "\n" +
                    "4. Add slices of fish and roll the sushi tightly. " + "\n" +
                    "5. Slice the roll into pieces and serve with soy sauce, wasabi, and pickled ginger.",

                    "1. Boil ramen noodles according to package instructions. " + "\n" +
                            "2. In a separate pot, prepare the broth with soy sauce, miso, and any desired ingredients. " + "\n" +
                            "3. Pour the broth over the cooked noodles. " + "\n" +
                            "4. Add toppings like boiled egg, sliced pork, and green onions. " + "\n" +
                            "5. Serve hot.",

                    "1. Prepare a batter using flour, cornstarch, and water. " + "\n" +
                            "2. Heat oil in a deep fryer or pan. " + "\n" +
                            "3. Dip shrimp, fish, or vegetables into the batter and fry until golden brown. " + "\n" +
                            "4. Serve with tempura dipping sauce.",

                    "1. Slice fresh fish (like tuna or salmon) into thin pieces. " + "\n" +
                            "2. Arrange the slices on a plate. " + "\n" +
                            "3. Serve with soy sauce, wasabi, and pickled ginger for dipping.",

                    "1. Marinate chicken in soy sauce, mirin, sugar, and sake. " + "\n" +
                            "2. Grill or pan-fry the chicken until cooked through and caramelized. " + "\n" +
                            "3. Serve with rice and garnish with sesame seeds and green onions.",

                    "1. Prepare takoyaki batter with flour, dashi stock, and egg. " + "\n" +
                            "2. Heat a takoyaki grill pan and fill each well with batter, followed by octopus pieces. " + "\n" +
                            "3. Cook, turning the takoyaki balls until golden and crispy. " + "\n" +
                            "4. Serve with takoyaki sauce, bonito flakes, and aonori.",

                    "1. Mix batter with flour, dashi, eggs, and shredded cabbage. " + "\n" +
                            "2. Add chopped meats, seafood, or vegetables to the batter. " + "\n" +
                            "3. Pour the mixture onto a hot, greased griddle. " + "\n" +
                            "4. Cook on both sides until golden and crispy. " + "\n" +
                            "5. Serve with okonomiyaki sauce, bonito flakes, and pickled ginger.",

                    "1. Mix matcha powder with sugar and a small amount of hot water to make a paste. " + "\n" +
                            "2. Combine the matcha paste with cream, milk, and egg yolks. " + "\n" +
                            "3. Pour the mixture into an ice cream maker and churn until it reaches a soft-serve consistency. " + "\n" +
                            "4. Freeze until firm and serve."},

            {"1. Cook rice noodles according to package instructions. " + "\n" +
                    "2. Stir-fry shrimp, tofu, or chicken in a pan with garlic, egg, and bean sprouts. " + "\n" +
                    "3. Add the noodles and toss with tamarind paste, fish sauce, sugar, and lime juice. " + "\n" +
                    "4. Serve with crushed peanuts, cilantro, and lime wedges.",

                    "1. In a pot, cook coconut milk with green curry paste, sugar, and fish sauce. " + "\n" +
                            "2. Add your choice of meat (chicken, beef, or pork) and vegetables. " + "\n" +
                            "3. Simmer until everything is cooked through. " + "\n" +
                            "4. Serve with steamed rice and garnish with fresh basil and chili.",

                    "1. Heat oil in a large pot and cook Massaman curry paste until fragrant. " + "\n" +
                            "2. Add coconut milk, potatoes, onions, and your choice of meat (beef or chicken). " + "\n" +
                            "3. Simmer until the meat is tender. " + "\n" +
                            "4. Serve with steamed rice and garnish with peanuts.",

                    "1. Shred papaya and carrots and place in a large bowl. " + "\n" +
                            "2. Add tomatoes, green beans, and roasted peanuts. " + "\n" +
                            "3. In a separate bowl, mix lime juice, fish sauce, palm sugar, and chili. " + "\n" +
                            "4. Toss everything together and serve as a refreshing salad.",

                    "1. Heat coconut milk in a pan and cook Panang curry paste until aromatic. " + "\n" +
                            "2. Add your choice of meat and simmer until fully cooked. " + "\n" +
                            "3. Add vegetables and simmer until tender. " + "\n" +
                            "4. Serve with rice and garnish with fresh basil.",

                    "1. Cook jasmine rice and set aside. " + "\n" +
                            "2. Stir-fry garlic, onion, and your choice of protein (chicken, shrimp, or tofu). " + "\n" +
                            "3. Add cooked rice, soy sauce, fish sauce, and sugar. " + "\n" +
                            "4. Stir-fry until everything is well combined. " + "\n" +
                            "5. Garnish with fresh cilantro and lime.",

                    "1. Soak bamboo skewers in water to prevent burning. " + "\n" +
                            "2. Marinate chicken in a mixture of coconut milk, soy sauce, garlic, and spices. " + "\n" +
                            "3. Thread the marinated chicken onto the skewers and grill until cooked through. " + "\n" +
                            "4. Serve with peanut sauce.",

                    "1. Cook red curry paste in coconut milk until fragrant. " + "\n" +
                            "2. Add your choice of protein (chicken, beef, or tofu) and simmer. " + "\n" +
                            "3. Add vegetables and cook until tender. " + "\n" +
                            "4. Serve with steamed rice and garnish with fresh herbs and chili."},

            {"1. Prepare the dough by mixing flour, butter, yeast, and water. " + "\n" +
                    "2. Roll out the dough and fold it several times to create layers. " + "\n" +
                    "3. Cut the dough into triangle shapes, roll them up, and shape them into croissants. " + "\n" +
                    "4. Let the dough rise, then bake at 375°F (190°C) for 15-20 minutes until golden and flaky.",

                    "1. Chop vegetables such as zucchini, eggplant, and bell peppers. " + "\n" +
                            "2. Sauté onions, garlic, and herbs (thyme, rosemary) in olive oil. " + "\n" +
                            "3. Add the vegetables and cook until tender, adding tomatoes and more herbs. " + "\n" +
                            "4. Simmer until everything is soft and well-cooked. " + "\n" +
                            "5. Serve with a drizzle of olive oil and fresh basil.",

                    "1. Brown chicken pieces in a pot with oil and bacon. " + "\n" +
                            "2. Add onions, garlic, and mushrooms, then pour in red wine and chicken stock. " + "\n" +
                            "3. Simmer for 1-2 hours until the chicken is tender and the sauce thickens. " + "\n" +
                            "4. Serve with mashed potatoes or crusty bread.",

                    "1. Sauté onions, garlic, leeks, and fennel in olive oil until softened. " + "\n" +
                            "2. Add tomatoes, white wine, and fish stock, and simmer. " + "\n" +
                            "3. Add a variety of seafood, such as shrimp, fish, and mussels. " + "\n" +
                            "4. Cook until the seafood is tender and serve with crusty bread and rouille sauce.",

                    "1. Brown beef chunks in a pot, then add carrots, onions, and garlic. " + "\n" +
                            "2. Add red wine, beef broth, and herbs (thyme, bay leaves), and simmer for several hours. " + "\n" +
                            "3. Add mushrooms and pearl onions towards the end of cooking. " + "\n" +
                            "4. Serve with mashed potatoes or crusty bread.",

                    "1. Whisk egg whites and sugar to stiff peaks, then fold in almond flour and powdered sugar. " + "\n" +
                            "2. Pipe the batter into small rounds on a baking sheet and let them rest. " + "\n" +
                            "3. Bake at 300°F (150°C) for 12-15 minutes until the macarons form feet. " + "\n" +
                            "4. Pair the shells together with buttercream or jam and refrigerate.",

                    "1. Prepare the pastry crust and bake it until golden. " + "\n" +
                            "2. Sauté onions and bacon, then add eggs, cream, cheese, and seasonings. " + "\n" +
                            "3. Pour the mixture into the crust and bake at 350°F (175°C) until set. " + "\n" +
                            "4. Serve warm or at room temperature.",

                    "1. Melt butter and mix with flour, eggs, and sugar to make the batter. " + "\n" +
                            "2. Pipe the batter into madeleine pans and bake at 375°F (190°C) for 10-12 minutes. " + "\n" +
                            "3. Remove from the pan, and let cool slightly before dusting with powdered sugar."},

            {"1. Brown lamb or beef in a pan with onions and garlic. " + "\n" +
                    "2. Add tomatoes, cinnamon, and nutmeg, and simmer for 1 hour. " + "\n" +
                    "3. Prepare the béchamel sauce with butter, flour, milk, and egg. " + "\n" +
                    "4. Layer the meat sauce, eggplant, and béchamel in a baking dish. " + "\n" +
                    "5. Bake at 350°F (175°C) for 45-60 minutes until golden and bubbly.",

                    "1. Grate cucumber and salt it to draw out moisture. " + "\n" +
                            "2. Mix with Greek yogurt, garlic, olive oil, lemon juice, and fresh dill. " + "\n" +
                            "3. Chill in the fridge for at least an hour before serving.",

                    "1. Sauté onions, garlic, and spinach in olive oil until wilted. " + "\n" +
                            "2. Mix the spinach with feta cheese, egg, and herbs (dill, parsley). " + "\n" +
                            "3. Layer the filling between sheets of phyllo dough, brushing with melted butter. " + "\n" +
                            "4. Bake at 350°F (175°C) for 30-40 minutes until golden brown and crispy.",

                    "1. Soak grape leaves in warm water, then rinse them. " + "\n" +
                            "2. Prepare the filling with rice, ground meat (optional), onions, and herbs (dill, mint). " + "\n" +
                            "3. Place a spoonful of filling in each leaf and roll tightly. " + "\n" +
                            "4. Simmer the rolls in a pot with lemon juice and olive oil for 45 minutes.",

                    "1. Combine chopped tomatoes, cucumbers, red onions, and olives in a bowl. " + "\n" +
                            "2. Add feta cheese, oregano, and a generous amount of olive oil. " + "\n" +
                            "3. Toss gently and season with salt and pepper.",

                    "1. Prepare the filo dough by brushing each sheet with melted butter. " + "\n" +
                            "2. Layer the filo sheets and sprinkle chopped walnuts and sugar between layers. " + "\n" +
                            "3. Cut the dough into squares or diamond shapes and bake at 350°F (175°C) for 40-45 minutes. " + "\n" +
                            "4. Pour warm honey syrup over the baked baklava and let it soak in.",

                    "1. Marinate the meat (lamb, beef, or chicken) with garlic, oregano, lemon juice, and olive oil. " + "\n" +
                            "2. Cook the meat on a vertical rotisserie or grill. " + "\n" +
                            "3. Serve the meat with pita bread, tomatoes, onions, and a drizzle of tzatziki sauce.", "\n" +

                    "1. Simmer white beans with onions, garlic, and tomatoes. " + "\n" +
                    "2. Add olive oil, bay leaves, and oregano. " + "\n" +
                    "3. Cook until the beans are tender and the soup thickens. " + "\n" +
                    "4. Serve with a drizzle of olive oil and a sprinkle of fresh parsley."},

            {"1. Blend chickpeas, tahini, olive oil, garlic, lemon juice, and cumin in a food processor until smooth. " + "\n" +
                    "2. Season with salt and pepper to taste. " + "\n" +
                    "3. Serve drizzled with olive oil, and garnish with paprika and parsley.",

                    "1. Soak dried chickpeas overnight and then grind them with onions, garlic, parsley, and spices (cumin, coriander). " + "\n" +
                            "2. Shape into small balls and deep fry in hot oil until golden and crispy. " + "\n" +
                            "3. Serve with tahini sauce or pita bread.",

                    "1. Marinate chicken (or lamb) in yogurt, garlic, lemon juice, olive oil, and spices (cumin, paprika, cinnamon). " + "\n" +
                            "2. Grill or roast the meat on a skewer or in a pan. " + "\n" +
                            "3. Serve with pita, veggies, and tahini or garlic sauce.",

                    "1. Combine parsley, tomatoes, cucumbers, and onions in a bowl. " + "\n" +
                            "2. Add bulgur wheat and mix. " + "\n" +
                            "3. Dress with olive oil, lemon juice, and salt. " + "\n" +
                            "4. Garnish with fresh mint leaves.",

                    "1. Mix flour, water, salt, and yeast to form a dough. " + "\n" +
                            "2. Let the dough rise and then divide into small balls. " + "\n" +
                            "3. Roll the balls into thin rounds and bake at a high temperature until puffed and golden. " + "\n" +
                            "4. Serve warm with hummus or shawarma.",

                    "1. Mix ground beef or lamb with onions, parsley, garlic, cumin, coriander, and cinnamon. " + "\n" +
                            "2. Form the mixture into skewers or patties. " + "\n" +
                            "3. Grill or cook on the stovetop until browned and cooked through. " + "\n" +
                            "4. Serve with pita and a side of yogurt sauce.",

                    "1. Combine lettuce, tomatoes, cucumbers, and radishes in a bowl. " + "\n" +
                            "2. Add crispy pieces of fried pita bread. " + "\n" +
                            "3. Dress with olive oil, lemon juice, and pomegranate molasses. " + "\n" +
                            "4. Sprinkle with sumac and parsley.",

                    "1. Cook lentils in water until tender, then drain. " + "\n" +
                            "2. Sauté onions, garlic, and carrots in olive oil, then add the cooked lentils. " + "\n" +
                            "3. Add vegetable broth, cumin, and coriander and simmer for 30 minutes. " + "\n" +
                            "4. Blend partially or fully for a creamy texture. Serve with a drizzle of olive oil."},

            {"1. Combine napa cabbage, radishes, garlic, ginger, chili flakes, and fish sauce to make the kimchi paste. " + "\n" +
                    "2. Massage the paste into the cabbage and let it ferment for several days at room temperature, then refrigerate.",

                    "1. Cook short-grain rice and let it cool. " + "\n" +
                            "2. Sauté vegetables (spinach, bean sprouts, zucchini, and mushrooms) separately with garlic and sesame oil. " + "\n" +
                            "3. Cook beef or pork in soy sauce, sugar, and sesame oil. " + "\n" +
                            "4. Serve the rice with the cooked vegetables, meat, a fried egg, and kimchi, topped with gochujang (Korean chili paste).",

                    "1. Marinate thinly sliced beef in soy sauce, sesame oil, garlic, sugar, and pepper. " + "\n" +
                            "2. Grill or stir-fry the beef until tender and slightly caramelized. " + "\n" +
                            "3. Serve with steamed rice and a side of kimchi.",

                    "1. Cook sweet potato noodles (dangmyeon) in boiling water. " + "\n" +
                            "2. Stir-fry vegetables (spinach, carrots, mushrooms, onions, and bell peppers) in sesame oil. " + "\n" +
                            "3. Mix the noodles with the stir-fried vegetables, and add soy sauce, sugar, sesame oil, and garlic. " + "\n" +
                            "4. Serve topped with a fried egg and a sprinkle of sesame seeds.",

                    "1. Marinate chicken pieces in soy sauce, garlic, ginger, sugar, and gochujang. " + "\n" +
                            "2. Dredge the marinated chicken in flour and cornstarch. " + "\n" +
                            "3. Deep fry until crispy and golden. " + "\n" +
                            "4. Toss the chicken in a sauce made of soy sauce, honey, garlic, and gochujang. " + "\n" +
                            "5. Garnish with sesame seeds and green onions.",

                    "1. Grill slices of pork belly until crispy and golden. " + "\n" +
                            "2. Serve with lettuce leaves, ssamjang (Korean dipping sauce), and sliced garlic. " + "\n" +
                            "3. Wrap the grilled pork belly in the lettuce with rice, and enjoy.",

                    "1. Simmer kimchi, pork or beef, tofu, garlic, ginger, and gochujang in a pot. " + "\n" +
                            "2. Let it cook until the meat is tender and the flavors are melded together. " + "\n" +
                            "3. Serve hot with steamed rice and extra kimchi on the side.",

                    "1. Mix flour, sugar, and water to make a dough. " + "\n" +
                            "2. Fill the dough with a mixture of brown sugar, cinnamon, and ground sesame seeds. " + "\n" +
                            "3. Shape the dough into small round cakes and fry until golden brown. " + "\n" +
                            "4. Serve hot, drizzled with honey or syrup."},
    };

    private final int[][] recipeImages = {
            {R.drawable.pizzamargherita, R.drawable.spaghetticarbonara, R.drawable.lasagna, R.drawable.risotto,
                    R.drawable.ravioli, R.drawable.gnocchi, R.drawable.tiramisu, R.drawable.pannacotta},
            {R.drawable.paneerbuttermasala, R.drawable.biryani, R.drawable.cholebhature, R.drawable.masaladosa,
                    R.drawable.pavbhaji, R.drawable.aooparatha, R.drawable.samosa, R.drawable.panipuri},
            {R.drawable.sweetandsours, R.drawable.friedrice, R.drawable.springrolls, R.drawable.chowmei,
                    R.drawable.dimsum, R.drawable.hotandsoursoup, R.drawable.szechuantofu, R.drawable.dumplings},
            {R.drawable.tacos, R.drawable.burritos, R.drawable.enchiladas, R.drawable.quesadillas,
                    R.drawable.churros, R.drawable.nachos, R.drawable.pozole, R.drawable.fajitas},
            {R.drawable.sushi, R.drawable.ramen, R.drawable.tempura, R.drawable.sashimi,
                    R.drawable.teriyakichicken, R.drawable.takoyaki, R.drawable.okonomiyaki, R.drawable.matchaicecream},
            {R.drawable.padthai, R.drawable.greencurry, R.drawable.massamancurry, R.drawable.somtum,
                    R.drawable.panangcurry, R.drawable.thaifriedrice, R.drawable.satay, R.drawable.redcurry},
            {R.drawable.croissants, R.drawable.ratatouille, R.drawable.coqauvin, R.drawable.bouillabaisse,
                    R.drawable.beefbourguignon, R.drawable.macarons, R.drawable.quichelorraine, R.drawable.madeleines},
            {R.drawable.moussaka, R.drawable.tzatziki, R.drawable.spanakopita, R.drawable.dolma,
                    R.drawable.greeksalad, R.drawable.baklava, R.drawable.gyro, R.drawable.fasolada},
            {R.drawable.hummus, R.drawable.falafel, R.drawable.shawarma, R.drawable.tabbouleh,
                    R.drawable.pitabread, R.drawable.kofta, R.drawable.fattoush, R.drawable.lentilsoup},
            {R.drawable.kimchi, R.drawable.bibimbap, R.drawable.bulgogi, R.drawable.japchae,
                    R.drawable.koreanfriedchicken, R.drawable.samgyeopsal, R.drawable.kimchijjigae, R.drawable.hotteok},
            // Add similar arrays for other cuisines
    };

    public RecipePagerAdapter(Context context, int cuisineIndex) {
        this.context = context;
        this.cuisineIndex = cuisineIndex;
    }

    @Override
    public int getCount() {
        return recipeNames[cuisineIndex].length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recipe_slider, container, false);

        ImageView imageView = view.findViewById(R.id.recipe_image);
        TextView textView = view.findViewById(R.id.recipe_name);
        TextView dtl1 = view.findViewById(R.id.dtl1);
        TextView dtl2 = view.findViewById(R.id.dtl2);

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.zoom);
        Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.zoom);
        imageView.setImageResource(recipeImages[cuisineIndex][position]);
        textView.setText(recipeNames[cuisineIndex][position]);

        imageView.startAnimation(animation);
        textView.startAnimation(animation2);

        dtl1.setText(recipeingrediant[cuisineIndex][position]);
        dtl2.setText(recipeinstruction[cuisineIndex][position]);

        container.addView(view);


        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public String[] getRecipeNames(int cuisineIndex) {
        return recipeNames[cuisineIndex]; // Return recipe names for the current cuisine
    }

}
