/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.apm.agent.core.context;

import org.apache.skywalking.apm.agent.core.context.ids.NewDistributedTraceId;
import org.apache.skywalking.apm.agent.core.profile.ProfileStatusContext;

public enum MockContextSnapshot {
    INSTANCE;

    private ContextSnapshot contextSnapshot;

    private ContextSnapshot ignoreContextSnapshot;

    MockContextSnapshot() {
        contextSnapshot = new ContextSnapshot(
            "1, 2, 3",
            1,
            new NewDistributedTraceId(),
            "/for-test-entryOperationName",
            new CorrelationContext(),
            new ExtensionContext(),
            ProfileStatusContext.createWithNone()
        );
        ignoreContextSnapshot = new ContextSnapshot(
                null,
                -1,
                null,
                null,
                new CorrelationContext(),
                new ExtensionContext(),
                ProfileStatusContext.createWithNone());
    }

    public ContextSnapshot mockContextSnapshot() {
        return contextSnapshot;
    }

    public ContextSnapshot mockIgnoreContextSnapshot() {
        return ignoreContextSnapshot;
    }
}
