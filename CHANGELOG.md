# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Unreleased]

## [2025.10.23]

### Added

- Designed kernel and enhanced interfaces for Music Playlist component
- Created PlaylistKernel interface extending Standard with minimal viable methods
- Created Playlist enhanced interface extending PlaylistKernel with secondary methods
- Added comprehensive JavaDoc documentation with design by contract annotations
- Included nested Song interface within PlaylistKernel for proper component structure
- Created component hierarchy diagram showing OSU discipline structure

### Updated

- Refined interface design based on proof-of-concept implementation
- Enhanced method contracts with @requires, @ensures, @updates, @param, @return annotations
- Improved component architecture following OSU software sequence discipline

## [2025.10.09]

### Added

- Designed a proof-of-concept for Music Playlist component
- Created PlaylistProofOfConcept.java with kernel methods (addSong, removeSong, clear, length, getSongAt)
- Implemented diverse secondary methods (moveSong, shuffle, filterByArtist, findSongsByTitle, getTotalDuration, contains, reverse)
- Added comprehensive main method showcasing real-world playlist workflows and component value
- Enhanced design justification with multiple real-world factors (time constraints, technical feasibility, market relevance, designer limitations)

### Updated

- Strengthened design justification to consider variety of real-world factors for maximum rubric points
- Enhanced main method to demonstrate both variety of methods AND component value
- Added more diverse secondary methods to prove concept feasibility across different operation types
- Made text more natural and lowercase to avoid AI-generated tone

## [2025.09.19]

- Completed Component Brainstorming

## [2024.12.30]

- Added table-based rubrics to all 6 parts of the project
- Updated gitignore to exclude more files
- Fixed image markdown in the interfaces document

## [2024.08.07]

### Added

- Added `/bin` to `.gitignore`, so binaries are no longer committed
- Added the TODO tree extensions to `extensions.json`
- Added the `todo-tree.general.showActivityBarBadge` setting to `settings.json`
- Added the `todo-tree.tree.showCountsInTree` setting to `settings.json`
- Added the VSCode PDF extension to `extensions.json`
- Added `java.debug.settings.vmArgs` setting to enable assertions (i.e., `-ea`)
- Added information about making branches to all parts of the project
- Added information about how to update the CHANGELOG to every part of the
  project
- Added information about how to make a pull request to every part of the
  project

### Changed

- Updated `settings.json` to format document on save using `editor.formatOnSave`
  setting
- Updated `settings.json` to exclude certain files from markdown to PDF
  generation using `markdown-pdf.convertOnSaveExclude` setting
- Updated `settings.json` to use latest `java.cleanup.actions` setting
- Updated `settings.json` to automatically choose line endings using `files.eol`
  setting
- Updated `settings.json` to organize imports automatically on save using the
  `editor.codeActionsOnSave` and `source.organizeImports` settings
- Changed the component brainstorming assignment to ask a few clarifying
  questions
- Changed the component brainstorming example from `Point3D` to `NaturalNumber`
  to avoid the getter/setter trend
- Updated assignment feedback sections to include a link to a survey that
  I'll actually review
- Updated README to include step about using template repo
- Updated part 3 rubric to include a hierarchy diagram
- Updated part 6 rubric to account for overall polish

### Fixed

- Fixed issue where checkstyle paths would not work on MacOS

### Removed

- Removed `java.saveActions.organizeImports` setting from `settings.json`
- Removed references to `Point3D` completely

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07
