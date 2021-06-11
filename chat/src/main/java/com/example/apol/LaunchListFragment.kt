import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo.coroutines.await
import com.example.apol.LaunchListQuery

class LaunchListFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(LaunchListQuery()).await()

            Log.d("LaunchList", "Success ${response?.data}")
        }
    }
}

