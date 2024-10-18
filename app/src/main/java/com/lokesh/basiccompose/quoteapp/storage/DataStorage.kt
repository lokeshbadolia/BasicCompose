package com.lokesh.basiccompose.quoteapp.storage


data class Quotes(
    val head: String,
    val desc: String,
)

fun getQuoteList(): MutableList<Quotes> {
   return mutableListOf(
       Quotes("Success is not final; failure is not fatal: It is the courage to continue that counts.", "Winston Churchill"),
       Quotes("It is better to fail in originality than to succeed in imitation.", "Herman Melville"),
       Quotes("The road to success and the road to failure are almost exactly the same.", "Colin R. Davis"),
       Quotes("Success usually comes to those who are too busy to be looking for it.", "Henry David Thoreau"),
       Quotes("Develop success from failures. Discouragement and failure are two of the surest stepping stones to success.", "Dale Carnegie"),
       Quotes("Nothing in the world can take the place of persistence. Talent will not; nothing is more common than unsuccessful men with talent. Genius will not; unrewarded genius is almost a proverb.", "Calvin Coolidge"),
       Quotes("There are three ways to ultimate success: The first way is to be kind. The second way is to be kind. The third way is to be kind.", "Mister Rogers"),
       Quotes("Success is peace of mind, which is a direct result of self-satisfaction in knowing you made the effort to become the best of which you are capable.", "John Wooden"),
       Quotes("I never dreamed about success. I worked for it.", "Estée Lauder"),
       Quotes("Success is getting what you want; happiness is wanting what you get.", "WP Kinsella"),
       Quotes("We cannot solve problems with the kind of thinking we employed when we came up with them.", "Albert Einstein"),
       Quotes("Learn as if you will live forever, live like you will die tomorrow.", "Mahatma Gandhi"),
       Quotes("Stay away from those people who try to disparage your ambitions. Small minds will always do that, but great minds will give you a feeling that you can become great too.", "Mark Twain"),
       Quotes("When you give joy to other people, you get more joy in return. You should give a good thought to the happiness that you can give out.", "Eleanor Roosevelt"),
       Quotes("When you change your thoughts, remember to also change your world.", "Norman Vincent Peale"),
       Quotes("It is only when we take chances that our lives improve. The initial and the most difficult risk we need to take is to become honest.", "Walter Anderson"),
       Quotes("Nature has given us all the pieces required to achieve exceptional wellness and health, but has left it to us to put these pieces together.", "Diane McLaren"),
       )
}