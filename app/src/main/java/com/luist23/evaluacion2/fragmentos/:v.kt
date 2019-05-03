/* package com.luist23.evaluacion2.fragmentos




private const val ARG_CONTENT = "CONTENT"


class ContentFragments: Fragment() {
    private var content: String? = null

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            content = it.getString(ARG_CONTENT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false).apply {
            tv_content.text =  content
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param content Display content.
         * @return A new instance of fragment ContentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(content: String) =
                ContentFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_CONTENT, content)
                    }
                }
    }
}
























val ARG_ACTION_1: String = "action_1"
val ARG_ACTION_2: String = "action_2"
val ARG_ACTION_3: String = "action_3"

class FakeBarFragment : Fragment() {

    var listener: OnSelectOption? = null
    var action1: String? = null
    var action2: String? = null
    var action3: String? = null


    companion object {

        fun newInstace(action1: String, action2: String,action3: String) =
                FakeBarFragment().apply {
                    arguments  = Bundle().apply {
                        putString(ARG_ACTION_1,action1)
                        putString(ARG_ACTION_2,action2)
                        putString(ARG_ACTION_3,action3)

                    }
                }
    }

    interface OnSelectOption {
        fun onAction(id: Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnSelectOption) {
            listener = context
        } else {
            throw RuntimeException("Se necesita una implementación de  OnSelectOption")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            action1 = getString(ARG_ACTION_1)
            action2 = getString(ARG_ACTION_2)
            action3 = getString(ARG_ACTION_3)
        }
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_fake_bar,
                    container, false).apply {
                bt_action1.apply {
                    text = action1
                    setOnClickListener {
                        listener?.onAction(1)
                    }
                }
                bt_action2.apply {
                    text = action2
                    setOnClickListener {
                        listener?.onAction(2)
                    }
                }

                bt_action3.apply {
                    text = action3
                    setOnClickListener {
                        listener?.onAction(3)
                    }
                }
            }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}



















class MainActivity : AppCompatActivity(), FakeBarFragment.OnSelectOption {

    override fun onAction(id: Int) {
        var content = when (id) {
            1 -> {
                "Hola"
            }
            2 -> {
                "Wiii"
            }
            3 -> {
                "Bye"
            }
            else -> {
                "Fuck!"
            }
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content, ContentFragment.newInstance(content))
                .addToBackStack("Co")
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barFragment = FakeBarFragment.newInstace(
                "Op1",
                "Op2",
                "Op3"
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_bar, barFragment)
                    .commit()
        }
    }
}

        */