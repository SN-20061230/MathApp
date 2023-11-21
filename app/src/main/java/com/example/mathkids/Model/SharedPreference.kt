
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreference(context: Context) {
    private val shared = context.getSharedPreferences("data", 0)
    private val edit = shared.edit()
    private val gson = Gson()

    private val records = "records"

    fun getRecords(): List<Pair<String, Int>> {
        val data = shared.getString(records, "")
        if (data == "") return listOf()
        val typeToken = object : TypeToken<List<Pair<String, Int>>>() {}.type
        return gson.fromJson(data, typeToken)
    }

    fun addRecord(name: String, score: Int): List<Pair<String, Int>> {
        val list = getRecords().toMutableList()
        list.add(Pair(name, score))
        edit.putString(records, gson.toJson(list)).apply()
        return list
    }
}