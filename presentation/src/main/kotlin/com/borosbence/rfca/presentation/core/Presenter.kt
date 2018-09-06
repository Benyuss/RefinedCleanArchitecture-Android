package com.borosbence.rfca.presentation.core

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

/**
 * Presenters are glue between views, VM-s and interactors.
 */
interface Presenter {

    var activity: AppCompatActivity

    /**
     * Call when the activity / fragment is in the onCreate state.
     * This lifecycle method executes the major initialization, calls the dependency injector, etc..
     */
    fun onCreate(savedInstanceState: Bundle?) { /* default implementation - override if needed */
    }

    /**
     * Call after the activity / fragment was in the onCreateView state.
     * This lifecycle method expects viewHolder object to be instantiated inside onCreateView.
     * UI manipulating methods should be called from here or from the following lifecycle methods.
     */
    fun onViewCreated(savedInstanceState: Bundle?) { /* default implementation - override if needed */
    }

    fun onActivityCreated(savedInstanceState: Bundle?) { /* default implementation - override if needed */
    }

    fun onCreateOptions(menu: Menu): Boolean { /* default implementation - override if needed */
        return false
    }

    fun onOptionsItemSelected(item: Menu): Boolean { /* default implementation - override if needed */ return false
    }

    /**
     * Call when the activity / fragment is in the onStart state.
     *
     * You should start stuff which was initialized in the previous lifecycle methods.
     */
    fun onStart() { /* default implementation - override if needed */
    }

    /**
     * Call when the activity / fragment is in the onResume state.
     *
     * You should call very short(in execution time) methods here because this method has high impact on the stuttering bugs.
     */
    fun onResume() { /* default implementation - override if needed */
    }

    /**
     * Call when the activity / fragment is in the onPause state.
     *
     * I don't really use this method but there could be some rare cases where you should.
     * Like halt some animations, etc..
     *
     * I just provided the chance to use this lifecycle method in the future presenters.
     */
    fun onPause() { /* default implementation - override if needed */
    }

    /**
     * Call when the activity / fragment is in the onStop state.
     *
     * In this lifecycle state you should free the weak references and other non-important resources which belongs only to the current state.
     */
    fun onStop() { /* default implementation - override if needed */
    }

    /**
     * Call when the activity / fragment is in the onDestroy state.
     *
     * This lifecycle method will destroy any open resources, dispose the subscriptions, etc..
     * Make sure to stop any context related stuff because you may encounter memory leaks if not.
     */
    fun onDestroy() { /* default implementation - override if needed */
    }
}