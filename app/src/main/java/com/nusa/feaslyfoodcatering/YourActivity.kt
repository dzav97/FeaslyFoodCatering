import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.inputmethod.InputMethodManager
import android.content.Context
import android.text.TextWatcher
import android.text.Editable
import com.nusa.feaslyfoodcatering.MenuAdapter
import com.nusa.feaslyfoodcatering.MenuItem

class YourActivity : AppCompatActivity() {

    private lateinit var menuAdapter: MenuAdapter
    private val menuItems = listOf(
        MenuItem("Nasi Goreng", "Nasi dengan campuran sayuran dan bumbu rempah"),
        MenuItem("Mie Goreng", "Mie dengan campuran telur dan kecap manis"),
        MenuItem("Sate Ayam", "Potongan daging ayam yang ditusuk dengan tusukan"),
        MenuItem("Gado-Gado", "Campuran sayuran dengan bumbu kacang"),
        MenuItem("Soto Ayam", "Kuah ayam dengan tambahan mie, tauge, dan bawang goreng")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.nusa.feaslyfoodcatering.R.layout.your_activity_layout)

        // Initialize RecyclerView, com.nusa.feaslyfoodcatering.MenuAdapter, and set layout manager
        val recyclerView: RecyclerView = findViewById(com.nusa.feaslyfoodcatering.R.id.recyclerView)
        menuAdapter = MenuAdapter(menuItems)
        recyclerView.adapter = menuAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize EditText
        val searchBar: EditText = findViewById(com.nusa.feaslyfoodcatering.R.id.searchBar)

        // Request focus for EditText
        searchBar.requestFocus()

        // Add TextWatcher to EditText
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Filter menu items based on the query text
                menuAdapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                // Not needed
            }
        })

        // Add OnKeyListener to EditText to handle Enter key press
        searchBar.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                // Filter menu items based on the query text
                menuAdapter.filter(searchBar.text.toString())
                // Hide keyboard
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(searchBar.windowToken, 0)
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        // Initialize search button
        val searchButton: Button = findViewById(com.nusa.feaslyfoodcatering.R.id.searchButton)
        searchButton.setOnClickListener {
            // Perform search when search button is clicked
            performSearch()
        }
    }

    private fun performSearch() {
        // Initialize EditText
        val searchBar: EditText = findViewById(com.nusa.feaslyfoodcatering.R.id.searchBar)
        // Filter menu items based on the query text
        menuAdapter.filter(searchBar.text.toString())
        // Hide keyboard
        hideKeyboard(searchBar)
    }

    private fun hideKeyboard(view: EditText) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
