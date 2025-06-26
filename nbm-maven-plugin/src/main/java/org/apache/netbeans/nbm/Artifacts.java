package org.apache.netbeans.nbm;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.RepositoryUtils;
import org.apache.maven.artifact.handler.manager.ArtifactHandlerManager;
import org.eclipse.aether.artifact.ArtifactType;
import org.eclipse.aether.artifact.ArtifactTypeRegistry;
import org.eclipse.aether.artifact.DefaultArtifactType;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Helper class for working with Resolver {@link org.eclipse.aether.artifact.Artifact} classes.
 */
@Singleton
@Named
public final class Artifacts {
    /**
     * Resolver artifact type registry backed by Maven Artifacts (legacy) ArtifactHandlerManager; it
     * knows about all the artifacts handlers registered with Maven, like our nbm are.
     */
    private final ArtifactTypeRegistry artifactTypeRegistry;

    public Artifacts(ArtifactHandlerManager artifactHandlerManager) {
        this.artifactTypeRegistry = RepositoryUtils.newArtifactTypeRegistry(artifactHandlerManager);
    }

    public static final ArtifactType NBM = new DefaultArtifactType();
}
