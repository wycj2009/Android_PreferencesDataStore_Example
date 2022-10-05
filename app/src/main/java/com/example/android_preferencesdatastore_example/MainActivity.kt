package com.example.android_preferencesdatastore_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.android_preferencesdatastore_example.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.button1.setOnClickListener {
            SettingPreferences.run {
                val newValue = getInt(this@MainActivity, SettingPreferences.KeySet.KEY_INT, 0) + 1
                put(this@MainActivity, SettingPreferences.KeySet.KEY_INT, newValue)
            }
        }
        binding.button2.setOnClickListener {
            SettingPreferences.run {
                var newValue = getDouble(this@MainActivity, SettingPreferences.KeySet.KEY_DOUBLE, 1.0) * 10.0
                if (newValue > 10E10) {
                    newValue = 1.0
                }
                put(this@MainActivity, SettingPreferences.KeySet.KEY_DOUBLE, newValue)
            }
        }
        binding.button3.setOnClickListener {
            SettingPreferences.run {
                var newValue = getString(this@MainActivity, SettingPreferences.KeySet.KEY_STRING, "") + "A"
                if (newValue.length > 10) {
                    newValue = "A"
                }
                put(this@MainActivity, SettingPreferences.KeySet.KEY_STRING, newValue)
            }
        }
        binding.button4.setOnClickListener {
            SettingPreferences.run {
                val newValue = getBoolean(this@MainActivity, SettingPreferences.KeySet.KEY_BOOLEAN, false).not()
                put(this@MainActivity, SettingPreferences.KeySet.KEY_BOOLEAN, newValue)
            }
        }
        binding.button5.setOnClickListener {
            SettingPreferences.run {
                var newValue = getFloat(this@MainActivity, SettingPreferences.KeySet.KEY_FLOAT, 1.0f) * 10.0f
                if (newValue > 10E5f) {
                    newValue = 1.0f
                }
                put(this@MainActivity, SettingPreferences.KeySet.KEY_FLOAT, newValue)
            }
        }
        binding.button6.setOnClickListener {
            SettingPreferences.run {
                val newValue = getLong(this@MainActivity, SettingPreferences.KeySet.KEY_LONG, 0) + 1
                put(this@MainActivity, SettingPreferences.KeySet.KEY_LONG, newValue)
            }
        }
        binding.button7.setOnClickListener {
            SettingPreferences.run {
                var newValue = getStringSet(this@MainActivity, SettingPreferences.KeySet.KEY_STRING_SET, emptySet()).let { it + setOf(('A'.code + it.size).toChar().toString()) }
                if (newValue.size > 10) {
                    newValue = setOf("A")
                }
                put(this@MainActivity, SettingPreferences.KeySet.KEY_STRING_SET, newValue)
            }
        }

        lifecycleScope.launch {
            launch {
                SettingPreferences.getIntFlow(this@MainActivity, SettingPreferences.KeySet.KEY_INT).collect {
                    binding.button1.text = "${SettingPreferences.KeySet.KEY_INT} = $it"
                }
            }
            launch {
                SettingPreferences.getDoubleFlow(this@MainActivity, SettingPreferences.KeySet.KEY_DOUBLE).collect {
                    binding.button2.text = "${SettingPreferences.KeySet.KEY_DOUBLE} = $it"
                }
            }
            launch {
                SettingPreferences.getStringFlow(this@MainActivity, SettingPreferences.KeySet.KEY_STRING).collect {
                    binding.button3.text = "${SettingPreferences.KeySet.KEY_STRING} = $it"
                }
            }
            launch {
                SettingPreferences.getBooleanFlow(this@MainActivity, SettingPreferences.KeySet.KEY_BOOLEAN).collect {
                    binding.button4.text = "${SettingPreferences.KeySet.KEY_BOOLEAN} = $it"
                }
            }
            launch {
                SettingPreferences.getFloatFlow(this@MainActivity, SettingPreferences.KeySet.KEY_FLOAT).collect {
                    binding.button5.text = "${SettingPreferences.KeySet.KEY_FLOAT} = $it"
                }
            }
            launch {
                SettingPreferences.getLongFlow(this@MainActivity, SettingPreferences.KeySet.KEY_LONG).collect {
                    binding.button6.text = "${SettingPreferences.KeySet.KEY_LONG} = $it"
                }
            }
            launch {
                SettingPreferences.getStringSetFlow(this@MainActivity, SettingPreferences.KeySet.KEY_STRING_SET).collect {
                    binding.button7.text = "${SettingPreferences.KeySet.KEY_STRING_SET} = $it"
                }
            }
        }
    }
}
