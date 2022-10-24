package com.example.skyvision.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.skyvision.DetailActivity
import com.example.skyvision.R

class ItemAdapter:
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //membuat daftar text yang akan ditampilkan di recycleview
    private val listname = listOf<String>(
        "Merkurius", "Venus", "Bumi", "Mars", "Jupiter", "Saturnus", "Uranus","Neptunus"
    )
    //membuat daftar image yang akan ditampilkan di recycleview
    private val listimage = listOf<Int>(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8
    )
    //mendefinisikan jumlah item yang dimunculkan di RecycleView
    override fun getItemCount(): Int {
        return listname.size
        return listimage.size
    }

    //membuat tempat untuk menaruh layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        layout.accessibilityDelegate = Accessibility
        return ItemViewHolder(layout)
    }

    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.item_image)
        val button = view.findViewById<Button>(R.id.button_item)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listname[position]
        holder.imageView.setImageResource(listimage[position])
        holder.button.text = item.toString()

       //menetapkan teks tombol ke onClickListener untuk holder.button
        holder.button.setOnClickListener {
            //dapatkan referensi ke context
            val context = holder.view.context
            //membuat Intent yang akan meneruskan konteks, serta nama class aktifitas tujuan
            val intent = Intent(context, DetailActivity::class.java)

            //memanggil metode putExtra dengan memasukkan "letter" sebagai argumen pertama dan button text sebagai argumen kedua
            intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
            //memanggil metode startActivity() pada objek konteks dengan meneruskan intent
            context.startActivity(intent)
        }

    }
    companion object Accessibility : View.AccessibilityDelegate() {
        override fun onInitializeAccessibilityNodeInfo(
            host: View,
            info: AccessibilityNodeInfo
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)

            val customString = host.context?.getString(R.string.look_up_words)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info.addAction(customClick)
        }
    }

}