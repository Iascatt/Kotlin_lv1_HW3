package com.example.kotlin_lv1_hw3.objects

import android.os.Parcel
import android.os.Parcelable
import com.example.kotlin_lv1_hw3.R
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.delay
import java.util.*

class Article() : Parcelable {
    @SerializedName("link")
    var link = ""

    @SerializedName("title")
    var title = ""

    @SerializedName("content")
    var content = ""

    @SerializedName("image_url")
    var image = "" //link

    @SerializedName("creator")
    var author: List<String> = listOf()

    @SerializedName("category")
    var categories: List<String> = listOf()

    @SerializedName("pubDate")
    var date = ""

    @SerializedName("description")
    var description = ""

    constructor(parcel: Parcel) : this() {
        link = parcel.readString() ?: ""
        title = parcel.readString() ?: ""
        content = parcel.readString() ?: ""
        image = parcel.readString() ?: ""
        author = parcel.createStringArrayList() ?: listOf()
        categories = parcel.createStringArrayList() ?: listOf()
        date = parcel.readString() ?: ""
        description = parcel.readString() ?: ""
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(link)
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(image)
        parcel.writeStringList(author)
        parcel.writeStringList(categories)
        parcel.writeString(date)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }

} /*{
    companion object {
        val all_articles: ArrayList<Article> = arrayListOf(
            Article(
                1,
                "Hot Yoga: Risks and Benefits",
                "“Hot yoga” is a term that can be used to describe just about any style of yoga practice performed in a warm or humid room. When a class is called “hot yoga” you could be holding poses for a minute or moving quickly from pose to pose, but two things are nearly always constant: heat and sweat.\n" +
                        "\n" +
                        "“Hot yoga, in the simplest terms, is yoga performed in a heated room,” says Samantha Scupp, the founder and a teacher at Heatwise, a New York City hot yoga studio, who is certified by Yoga Alliance, the world’s largest nonprofit yoga association that certifies teachers and schools.\n" +
                        "\n" +
                        "Hot yoga classes vary in length but typically last 60 to 120 minutes. Participants can sweat out up to three or four pounds of water in just one class, most of which will be replaced once the person is fully hydrated, according to a 2017 study. (1)\n" +
                        "\n" +
                        "Hot yoga classes often include postures and breathing techniques from other traditional yoga, but the practice of intentionally heating the room higher than normal just for yoga is a somewhat newer concept.\n" +
                        "\n" +
                        "RELATED: 8 Yoga Poses for Beginners\n" +
                        "\n" +
                        "Bikram yoga, founded in the 1970s by Bikram Choudhury, is generally recognized as the first style of hot yoga. Bikram yoga classes all include a very specific sequence of 26 yoga poses and two breathing exercises performed in the same order, within 90 minutes, in a room heated to over 100 degrees Fahrenheit. (2) While Bikram classes are recognized as following a specific format, because the technique is based on traditional yoga poses, a California court ruled in 2015 that Choudhury could not copyright the sequence. (3)\n" +
                        "\n" +
                        "Choudhury’s franchise, Bikram Yoga, has been controversial because of his desire to own this technique and because several sexual assault and sexual harassment lawsuits were filed against him in the past decade. Choudhury himself fled the United States after a warrant for his arrest was issued in 2017 because of his refusal to pay damages. (4) A 2019 Netflix documentary titled Bikram: Yogi, Guru, Predator details much of the controversy surrounding the hot yoga leader. \n" +
                        "\n" +
                        "Bikram is probably the most well-known style of hot yoga, but there are several other styles.\n" +
                        "\n" +
                        "“Hot flow” or “power flow” is a vinyasa style of yoga, says Scupp. “It’s different every time, the movements flow together, and music is often used,” she says.\n" +
                        "\n" +
                        "In vinyasa yoga, participants are encouraged to coordinate breath with movement as they “flow” from one pose to the next; and the order of the poses (and potentially even which poses are performed) may change from class to class, Scupp says.",
                R.drawable.fitness,
                "Becky Upham",
                listOf("Fitness"),
                "01.12.2022"
            ),

            Article(
                2,
                "Pilates: Health Benefits, How to Get Started, and How to Get Better",
                "Pilates — once a niche strength, mobility, and recovery technique for dancers — has gone mainstream. The low-intensity, muscle-strengthening workout can promote flexibility, mobility, and posture. What’s more, it can set your body up to complete other more intense strength-training safely.\n" +
                        "\n" +
                        "You can find classes at fitness studios and gyms across the country, as well as online.\n" +
                        "\n" +
                        "Read on to learn what it is, the health benefits it offers, and how to get started.\n" +
                        "\n" +
                        "What Is Pilates?\n" +
                        "Pilates — an exercise technique that was created by Joseph Pilates, an athlete and physical trainer, in the early 1900s — uses roughly 50 exercises to work the muscles, enhance endurance, and improve balance, posture, and flexibility, according to a previous review.\n" +
                        "\n" +
                        "“It helps to work on smaller muscle groups, stabilizing muscle groups, and the core — the muscles in our trunk,” says Heather Milton, CSCS, a board-certified clinical exercise physiologist with NYU Langone Health in New York City. Building those muscles can help you complete everyday tasks more easily, and lower your risk of injury, she says.\n" +
                        "\n" +
                        "Pilates can boost your overall fitness. A small study in people who were overweight or obese, published February 2019 in PeerJ, found that three one-hour Pilates sessions per week helped participants improve lean and fat mass, trunk endurance, and flexibility.\n" +
                        "\n" +
                        "But Milton says most people should consider Pilates a complement to your aerobic exercise and resistance training rather than the only type of workout you do.\n" +
                        "\n" +
                        "The U.S. Department of Health and Human Services (HHS) Physical Activity Guidelines (PDF) recommend that adults do 150 minutes of moderate-intensity aerobic activity plus two strength-training sessions each week. \n" +
                        "\n" +
                        "Pilates doesn’t exactly fit as a standalone strength workout, however, because there’s not enough resistance involved. \n" +
                        "\n" +
                        "Jesse Barnett, CSCS, a Pilates instructor and National Strength and Conditioning Association–certified personal trainer with Physical Equilibrium in New York City and East Hampton, New York, says a true strength-training workout would involve heavy resistance of some kind, and movement that taxes the muscle you’re working to the point of fatigue.\n" +
                        "\n" +
                        "But, it’s also important to consider your current fitness level. For people who don’t move much, or for older adults with less fitness, reducing sedentary behavior with an activity like Pilates can offer health benefits, according to the HHS Physical Activity Guidelines. Lower intensity exercises will feel more vigorous to these individuals. \n" +
                        "\n" +
                        "And some Pilates classes can be more challenging. \n" +
                        "\n" +
                        "The Health and Human Services guidelines call out yoga and tai chi as two types of exercise that vary in intensity. Pilates is similar, says Tasha Edwards, an American Council on Exercise (ACE)–certified wellness coach and founder of Hip Healthy Chick based in Huntsville, Alabama. \n" +
                        "\n" +
                        "Taking a reformer Pilates class, which is Pilates performed on a reformer machine that uses spring systems for added resistance, is one way to increase the intensity, says Edwards, who is also an Athletics and Fitness Association of America–certified personal trainer and a fitness instructor certified in Pilates, yoga, barre, and Zumba. \n" +
                        "\n" +
                        "But ultimately to achieve more fitness, you should be doing both strength training and Pilates, and not one or the other, she says.\n" +
                        "\n" +
                        "There’s no set guideline for how often you should do Pilates, but Edwards and Milton recommend twice per week, in addition to other workouts.",
                R.drawable.fitness,
                "Moira Lawler",
                listOf("Fitness"),
                "06.10.2022"
            )
        )
    }
}*/