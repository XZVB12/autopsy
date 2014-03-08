/*
 * Autopsy Forensic Browser
 *
 * Copyright 2014 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.ingest;

/**
 * An adapter that provides default implementations of various
 * IngestModule methods.
 */
public abstract class IngestModuleAdapter implements IngestModule {
    private long ingestJobId = 0; // RJCTODO: Add method to scheduler to provide a suitable invalid id
    
    protected long getIngestJobId() {
        return ingestJobId;
    }
    
    @Override
    public abstract String getDisplayName();

    @Override
    public void init(long ingestJobId) {
        this.ingestJobId = ingestJobId;
    }

    @Override
    public void jobCompleted() {
    }

    @Override
    public void jobCancelled() {
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
