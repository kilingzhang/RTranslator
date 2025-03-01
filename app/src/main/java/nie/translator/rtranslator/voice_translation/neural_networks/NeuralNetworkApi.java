/*
 * Copyright 2016 Luca Martino.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copyFile of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nie.translator.rtranslator.voice_translation.neural_networks;

import java.util.ArrayList;
import nie.translator.rtranslator.Global;

public class NeuralNetworkApi {
    protected Global global;
    private ArrayList<Thread> pendingThreads= new ArrayList<>();

    protected void addPendingThread(Thread thread){
        pendingThreads.add(thread);
    }

    protected Thread takePendingThread(){
        if(pendingThreads.size()>0) {
            return pendingThreads.remove(0);
        }else{
            return null;
        }
    }

    public interface InitListener{
        void onInitializationFinished();
        void onError(int[] reasons, long value);
    }
}
